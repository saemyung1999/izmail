var index = {
    init : function () {
        var _this = this;
        $("#btn-mailConfirm").on("click", function () {
            _this.confirm();
        });
    },
    confirm: function () {
        var memberName = $("#memberName").text();
        console.log(memberName);

        $.ajax({
            type: 'GET',
            url: '/mailConfirm/' + memberName
        }).done(function (result) {
            console.log(result)
            console.log(typeof(result))
            if (result == true) {
                alert(memberName + "의 메일이 도착함");
                $("#btn-result").html("메일 전송됨");
                $("#btn-result").attr("class", "btn btn-sm btn-danger");
                $("#btn-result").removeAttr("style");
            } else {
                alert(memberName + "의 메일이 아직 도착하지 않음. 어서 변경해!!");
                $("#btn-result").html("메일 전송x");
                $("#btn-result").attr("class", "btn btn-sm btn-primary");
                $("#btn-result").removeAttr("style");
            }
        })
    }
}
index.init();