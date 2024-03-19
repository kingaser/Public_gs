
/* 아작스 공통 함수 */
/* Jquery 를 사용한다.
 * 스크립트단 너무 지저분해 져서 만들어 본다.
 * 잘되면 좋고 안되면 말고
 * 일단 해보자 .
 * */


function fnAjax(url,para)  // 호출할 페이지 , 던질 파라미터  xml오브젝트를 리턴해준다. 그담은 알아서 사용 하면 된다.
{
    var retxml;
    $.ajax({
        type : "POST"
        ,async : false
        ,url : url
        ,dataType : "xml"
        ,data : para
        ,contentType : "application/x-www-form-urlencoded;charset=UTF-8"
        ,error : function(request,status,error){
            //alert("ajax 실행중 오류가 발생했습니다.");
            alert(error);
        }
        ,success : function(response,status,request){

            retxml = response;
        }
    });
    return retxml;

}

function fnAjaxJson(url,para)  // 호출할 페이지 , 던질 파라미터 json오브젝트를 리턴해준다. 그담은 알아서 사용 하면 된다.
{
    var retJson;
    $.ajax({
        type : "GET"
        ,async : false
        ,url : url
        ,dataType : "json"
        ,data : para
        ,contentType : "application/x-www-form-urlencoded;charset=UTF-8"
        ,error : function(request,status,error){
            //alert("ajax 실행중 오류가 발생했습니다.");
            alert("error : " + error);
        }
        ,success : function(response,status,request){
            retJson = response;
        }
    });
    return retJson;

}

function fnAjaxText(url,para)  // 호출할 페이지 , 던질 파라미터  text오브젝트를 리턴해준다. 그담은 알아서 사용 하면 된다.
{
    var retText;
    $.ajax({
        type : "POST"
        ,async : false
        ,url : url
        ,dataType : "text"
        ,data : para
        ,contentType : "application/x-www-form-urlencoded;charset=UTF-8"
        ,error : function(request,status,error){
            //alert("ajax 실행중 오류가 발생했습니다.");
            alert(error);
        }
        ,success : function(response,status,request){

            retText = response;
        }
    });
    return retText;

}
function fnAjaxHtml(url,para)  // 호출할 페이지 , 던질 파라미터  text오브젝트를 리턴해준다. 그담은 알아서 사용 하면 된다.
{
    var retText;
    $.ajax({
        type : "POST"
        ,async : false
        ,url : url
        ,dataType : "html"
        ,data : para
        ,contentType : "application/x-www-form-urlencoded;charset=UTF-8"
        ,error : function(request,status,error){
            //alert("ajax 실행중 오류가 발생했습니다.");
            alert(error);
        }
        ,success : function(response,status,request){

            retText = response;
        }
    });
    return retText;

}