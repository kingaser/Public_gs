let updateSerialNo;

const getStatusDetail = ((serialNo) => {
    console.log('선택 호출')
    let serial = serialNo;
    console.log('serial ' + serial);

    $.ajax({
        type: "GET",
        url: `/park/status/` + serial,
        contentType: "application/json",
        success: function (result) {
            console.log(result);
            $("#enterDate").val(result.enterDate.substring(0, 10));
            $("#enterHour").val(result.enterDate.substring(11, 13));
            $("#enterMinute").val(result.enterDate.substring(14, 16));
            $("#enterUser").val(result.enterUser);
            $("#spaceNm").val(result.spaceNm);
            $("#carNo").val(result.carNo);
            $("#spotCount").val(result.spotCount);
            $("#spotNo").val(result.spotNo);
            $("#discountCode").val(result.discountCode);
            $("#outDate").val(result.leaveDate.substring(0, 10));
            $("#outHour").val(result.leaveDate.substring(11, 13));
            $("#outMinute").val(result.leaveDate.substring(14, 16));
            $("#leaverUser").val(result.leaverUser);
            $("#recpNo").val(result.recpNo);
            $("#gasan").val(result.gasan);
            $("#cutAmount").val(result.cutAmount);
            $("#saleAmount").val(result.saleAmount);
            $("#discAmount").val(result.discAmount);
            $("#receiveAmount").val(result.receiveAmount);
            $("#userRemark").val(result.userRemark);
            $("#remark").val(result.remark);
            $("#accGubun").val(result.accGubun);
            $("#recpDt").val(result.recpDt);
            $("#gojiState").val(result.gojiState);
            $("#origAmount").val(result.origAmount);
            updateSerialNo = result.serialNo;
        },
        error: function (err) {
            console.log(err);
        }
    })
})

const searchStatus = () => {
    $('.table_body').empty();
    $.ajax({
        type: 'get',
        url: '/park/search',
        data: {
            carNo: $('#searchCarNo').val(),
            spaceNo: $('#searchSpaceNo').val(),
            dateType: $('#dateType').val(),
            enterDate: $('#searchEnterDate').val(),
            leaveDate: $('#searchLeaveDate').val(),
            proceTag: $('#searchProceTag').val()
        },
        success: function (res) {
            let str = '';
            $.each(res, function (i)
            {
                $.each(res[i], function (j) {
                    res[i][j] = res[i][j] != null ? res[i][j] : '';
                })
                str += '<tr onclick="getStatusDetail(' + '\'' + res[i].serialNo + '\'' + ')">' +
                        '<td>' + res[i].spaceNm + '</td>'+
                        '<td>' + res[i].enterDate + '</td>'+
                        '<td>' + res[i].leaveDate + '</td>'+
                        '<td>' + res[i].carNo + '</td>'+
                        '<td>' + res[i].recpDt + '</td>'+
                        '<td>' + res[i].accGubun + '</td>'+
                        '<td>' + res[i].origAmount + '</td>'+
                        '<td>' + res[i].saleAmount + '</td>'+
                        '<td>' + res[i].discAmount + '</td>'+
                        '<td>' + res[i].gasan + '</td>'+
                        '</tr>'
            })
            $('.table_body').append(str);
        },
        error: (err) => {
            console.log('에러' + err);
        }
    })
}

const updateStatus = () => {

    let updateData = {
        discountCode: $('#discountCode').val(),
        leaverUser: $('#leaverUser').val(),
        leaveType: $('#leaveType').val(),
        userRemark: $('#userRemark').val(),
        remark: $('#remark').val(),
        accGubun: $('#accGubun').val(),
        gojiState: $('#gojiState').val(),
    }
}
