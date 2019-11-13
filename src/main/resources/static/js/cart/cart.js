(function () {

// $('[data-td="checked"]').checked

    // console.log($('[data-td="checked"]').checked)



})();

function check(check) {
    var $checks = $(check);
    if (check.checked){
        color = "rgb(223,223,255)";
        $checks.parent().parent().css('background-color',color);
    } else{
        color = "transparent";
        $checks.parent().parent().css('background-color',color);
    }

}

function checks(checks) {

    console.log(checks.checked)
    if (checks.checked){

        $('[data-td="checked"]').prop("checked",true);
        color = "rgb(223,223,255)";
        $('[data-tr="checked"]').children().css('background-color',color);

    }else{
        $('[data-td="checked"]').prop("checked",false);
        color = "transparent";
        $('[data-tr="checked"]').children().css('background-color',color);

    };

}
