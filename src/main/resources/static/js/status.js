let proceTag = '0';
$('#cancelBtn').hide();

const getStatusDetail = ((serialNo) => {
    let serial = serialNo;

    $.ajax({
        type: "GET",
        url: `/park/status/` + serial,
        contentType: "application/json",
        success: function (result) {
            $('#selectSerial').val(result.serialNo);
            if (result.enterDate != null) {
                $('#enterDate').val(result.enterDate.substring(0, 10));
                $('#enterHour').val(result.enterDate.substring(11, 13));
                $('#enterMinute').val(result.enterDate.substring(14, 16));
            }
            $('#enterUser').val(result.enterUser);
            $('#spaceNm').val(result.spaceNm);
            $('#carNo').val(result.carNo);
            $('#spotCount').val(result.spotCount);
            $('#spotNo').val(result.spotNo);
            $('#discountCode').val(result.discountCode);
            if (result.leaveDate != null) {
                $('#outDate').val(result.leaveDate.substring(0, 10));
                $('#outHour').val(result.leaveDate.substring(11, 13));
                $('#outMinute').val(result.leaveDate.substring(14, 16));
            }
            $('#leaverUser').val(result.leaverUser);
            $('#recpNo').val(result.recpNo);
            $('#gasan').val(result.gasan);
            $('#cutAmount').val(result.cutAmount);
            $('#saleAmount').val(result.saleAmount);
            $('#discAmount').val(result.discAmount);
            $('#receiveAmount').val(result.receiveAmount);
            $('#userRemark').val(result.userRemark);
            $('#remark').val(result.remark);
            $('#accGubun').val(result.accGubun);
            $('#recpDt').val(result.recpDt);
            $('#gojiState').val(result.gojiState);
            $('#origAmount').val(result.origAmount);
            proceTag = result.proceTag;
            console.log('proceTag = ', proceTag)
            if (proceTag === '0' || proceTag === '9') {
                $('#cancelBtn').hide();
                $('#payBtn').show();
            } else if (proceTag === '1') {
                $('#payBtn').hide();
                $('#cancelBtn').show();
            }
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
            $.each(res, function (i) {
                $.each(res[i], function (j) {
                    res[i][j] = res[i][j] != null ? res[i][j] : '';
                })
                str += '<tr onclick="getStatusDetail(' + '\'' + res[i].serialNo + '\'' + ')">' +
                    '<td>' + res[i].spaceNm + '</td>' +
                    '<td>' + res[i].enterDate + '</td>' +
                    '<td>' + res[i].leaveDate + '</td>' +
                    '<td>' + res[i].carNo + '</td>' +
                    '<td>' + res[i].recpDt + '</td>' +
                    '<td>' + res[i].accName + '</td>' +
                    '<td>' + res[i].origAmount + '</td>' +
                    '<td>' + res[i].saleAmount + '</td>' +
                    '<td>' + res[i].discAmount + '</td>' +
                    '<td>' + res[i].gasan + '</td>' +
                    '<td>' + res[i].receiveAmount + '</td>' +
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
    let serial = $('#selectSerial').val();

    let data = {
        enterDate: $('#enterDate').val(),
        enterHour: $('#enterHour').val(),
        enterMinute: $('#enterMinute').val(),
        enterUser: $('#enterUser').val(),
        spaceNm: $('#spaceNm').val(),
        carNo: $('#carNo').val(),
        spotCount: $('#spotCount').val(),
        spotNo: $('#spotNo').val(),
        discountCode: $('#discountCode').val(),
        outDate: $('#outDate').val(),
        outHour: $('#outHour').val(),
        outMinute: $('#outMinute').val(),
        leaverUser: $('#leaverUser').val(),
        leaveType: $('#leaveType').val(),
        recpNo: $('#recpNo').val(),
        gasan: $('#gasan').val(),
        cutAmount: $('#cutAmount').val(),
        origAmount: $('#origAmount').val(),
        discAmount: $('#discAmount').val(),
        saleAmount: $('#saleAmount').val(),
        userRemark: $('#userRemark').val(),
        remark: $('#remark').val(),
        gojiState: $('#gojiState').val()
    };

    $.ajax({
        type: 'patch',
        url: '/park/status/' + serial,
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        success: function (res) {
            console.log(res);
            searchStatus();
        },
        error: (err) => {
            console.log('에러' + err);
        }
    })
}

const deleteStatus = () => {
    let serial = $('#selectSerial').val();
    $.ajax({
        type: 'delete',
        url: '/park/status/' + serial,
        success: function (res) {
            console.log(res);
            searchStatus();
        },
        error: (err) => {
            console.log('에러' + err);
        }
    })
}