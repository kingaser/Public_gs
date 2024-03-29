function Date_Comma(cellValue) {
    if(cellValue == "" || cellValue == null){
        return '..';
    }else{
        var yyyy = cellValue.substring(0,4);
        var mm = cellValue.substring(4,6);
        var dd = cellValue.substring(6,8);
        return yyyy+'.'+mm+'.'+dd;
    }

}

function trim(parm_str) {  // 공백제거 함수
    return parm_str.replace(/\s/g, "");
}
function Month_Comma(cellValue) {
    if(cellValue == "" || cellValue == null){
        return '..';
    }else{
        var yyyy = cellValue.substring(0,4);
        var mm = cellValue.substring(4,6);
        return yyyy+'.'+mm;
    }

}
function Date_Format_Time(cellValue) {
    return cellValue.match(/\d{2}/g).join(":")
}
function Amt1000Mark(cellValue, options, rowObject) {
    var Amt =  Mark1000Sep(cellValue);
    return Amt;
}
function StringToMoney(input){
    var str=input.toString();
    str=str.replace(/,/g,"");
    var len=str.length;
    var strtmp="";
    if(len>3){
        for(var row=0;len-row-3>0;row+=3){
            strtmp=","+str.substring(len-3-row,len-row)+strtmp;
        }
        strtmp=str.substring(0,len-row)+strtmp;
    }else{
        strtmp=input;
    }
    return strtmp;
}
function StringToBank(input){
    var str=input.toString();
    str=str.replace(/-/g,"");
    var len=str.length;
    var strtmp="";
    if(len>4){
        for(var row=0;len-row-4>0;row+=4){
            strtmp="-"+str.substring(len-4-row,len-row)+strtmp;
        }
        strtmp=str.substring(0,len-row)+strtmp;
    }else{
        strtmp=input;
    }
    return strtmp;
}

function checking(obj) // 문자열 체크 (숫자+영문조합인지 체크하는 함수)
{
    var ret = "";
    var result = (/[^a-zA-Z0-9_]/).test(obj);
    if(result )
    {
        alert("숫자, 영문, '_' 를 제외한 특수문자는 입력할 수 없습니다!!");
        return false;
    }
    else if(!obj.match(/\d+/g) || !obj.match(/[a-z]+/gi))
    {
        alert("영문과 숫자의 조합만 가능합니다.");
        return false;
    }
    else
    {
        return true;
    }
}

function checkpass(obj) // 문자열 체크 (숫자+영문조합인지 체크하는 함수)
{
    if(!obj.match(/\d+/g) || !obj.match(/[a-z]+/gi))
    {
        alert("비밀번호는 영문과 숫자의 조합만 가능합니다.");
        return false;
    }
    else
    {
        return true;
    }
}

function Remove1000Sep(p_nMoney)  // 숫자 3자리마다 , 찍힌거 없애기
{
    return p_nMoney.replace(/,/g,"");
}
// 금액, 타입, 절삭금액 단위    // 원단위처리(R:반올림, C:올림, F:버림)
function priceCutting(aprice, stype, n) {
    alert("priceCutting");
    alert("aprice : "+ aprice);
    var remove_price = 0;
    stype = stype ? stype : "R";
    remove_price = aprice / n;
    alert("remove_price ="+remove_price);
    if(stype == "F") {
        remove_price = Math.floor(remove_price);
    } else if (stype == "R") {
        remove_price = Math.round(remove_price);
    } else if (stype == "C") {
        remove_price = Math.ceil(remove_price);
    }
    remove_price = remove_price * n;
    return remove_price;
}

function getToday()  // 오늘 가져오기
{
    var d = new Date();

    var strYear = d.getFullYear();
    var strMonth = "0"+(d.getMonth()+1);
    strMonth = strMonth.substring(strMonth.length-2, strMonth.length);
    var strDay = "0"+d.getDate();
    strDay = strDay.substring(strDay.length-2, strDay.length);
    //alert(strMonth);
    //alert(strDay);

    var strTime ;
    strTime = strYear+"/"+strMonth+"/"+strDay;
    return strTime;
}

function getTime(mark)  // 시분초 가져오기
{
    var d = new Date();

    var hh = "0"+(d.getHours());
    hh = hh.substring(hh.length-2, hh.length);
    var mm = "0"+(d.getMinutes());
    mm = mm.substring(mm.length-2, mm.length);
    var ss = "0"+(d.getSeconds());
    ss = ss.substring(ss.length-2, ss.length);

    var strTime;
    if( mark != null || mark != undefined ){
        strTime = hh + mark + mm + mark + ss;
    } else {
        strTime = hh +''+ mm +''+ ss;
    }
    return strTime;
}

function checkExt(filename)  // 이미지 파일만 등록 가능하게  파일명을 넘겨 준다.
{
    var IMG_FORMAT = "\.(bmp|gif|jpg|jpeg|png)$"; //문서만 첨부하게 하려면 이 부분 바꿔주시면 되겠죠? ^^

    if((new RegExp(IMG_FORMAT, "i")).test(filename)) {
        return true;
    }
    else {
        alert("이미지 파일만 첨부하실 수 있습니다.   ");
        return false;
    }
}

function checkXls(filename)  // xls 파일만 등록 가능하게  파일명을 넘겨 준다.
{
    var IMG_FORMAT = "\.(xls)$"; //문서만 첨부하게 하려면 이 부분 바꿔주시면 되겠죠? ^^
    if((new RegExp(IMG_FORMAT, "i")).test(filename)) {
        return true;
    }
    else {
        alert("xls 파일만 첨부하실 수 있습니다.");
        return false;
    }
}

function TimeString(time)  // 시간 09:00 으로 표시하기 입력값은 0900
{
    var str = time;
    str = str.substring(0,2)+":"+str.substring(2,4);
    return str;
}

function postNewWindow(form) { // 새창 띠우기
    form.method = "post";
    form.action = window.location.pathname;
    form.target = "_blank";
    form.submit();
    form.target = "_self";
}

function Left(str, n){ // 왼쪽부터 n만큼 자르기
    if (n <= 0)
        return "";
    else if (n > String(str).length)
        return str;
    else
        return String(str).substring(0,n);
}

function Right(str, n){ //오른쪽부터 n만큼 자르기
    if (n <= 0)
        return "";
    else if (n > String(str).length)
        return str;
    else {
        var iLen = String(str).length;
        return String(str).substring(iLen, iLen - n);
    }
}


/*******************************************************************
 *********************    DB접근 데이터 조회  ( ID / 도메인 / 전체포함,미포함  ***********************
 ******************************************************************/
function getSelectCommonCode(SELECT_ID, URL, SELECT_OPTION){
    var url = URL;
    var param = {}
    var resultJson = fnAjaxJson(url,param);
    var option = "";
    if ($(resultJson).length > 0) {
        if(SELECT_OPTION=="all"){
            option += "<option value=''>전체</option>";
        }else if(SELECT_OPTION=="misu"){
            option += "<option value='00'>미수</option>";
        }
        $.each(resultJson, function(i, n) {
            option += "<option value='"+ n.codeNo + "' id='"+ n.codeNo + "'>"+ n.codeNm	+ "</option>";
        });
        $("#"+SELECT_ID).html(option);
   }
}
