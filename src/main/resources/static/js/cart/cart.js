(function () {


})();
var color = "rgb(223,223,255)";
var colors = "transparent";
// 单选
function check(check) {
    let $this = $(check);
    if (check.checked){
        $this.parent().parent().css('background-color',color);
    };
    if(check.checked == false){
        $this.parent().parent().css('background-color',colors);
    };
};

// 多选
function checks(checks) {
    if (checks.checked){
        $('[data-td="checked"]').prop("checked",true);
        $('[data-tr="checked"]').children().css('background-color',color);
    };
    if (checks.checked == false){
        $('[data-td="checked"]').prop("checked",false);
        $('[data-tr="checked"]').children().css('background-color',colors);
    };
};

// 增加数量
function addNumber(number) {
    let $this = $(number);
    // 获取数量input中的数字
    let numbers = Number($this.prev().find('input').val());

    // 获取加数量的所在行的复选框
    let check = $this.parent().parents().siblings($('[data-js="selects"]')).children($('[data-td="checked"]'));

    // 点击加数量的时候复选框点选以及背景色显示
    check.prop("checked",true);
    $this.parent().parent().parent().css('background-color', color);

    // 操作反馈,添加数量
    let numberAdd = numbers + Number(1);
    $this.siblings($('[role="group"]')).children($('[data-js="number"]')).val(numberAdd);
}

// 减少数量
function minusNumber(number) {
    let $number = $(number);

    // 获取数量input中的数字
    let numbers = Number($number.parent().find('input').val());

    // 获取减数量的所在行的复选框
    let check = $number.parent().parents().siblings($('[data-js="selects"]')).children($('[data-td="checked"]'));

    // 点击减数量的时候复选框点选以及背景色显示
    check.prop("checked", true);
    $number.parent().parent().parent().css('background-color', color);

    // 判断数量，数量小于1的时候不进行操作
    if (numbers > 1) {
        // 操作反馈,添加数量
        let minusNumber = numbers - Number(1);
        $number.siblings($('[role="group"]')).children($('[data-js="number"]')).val(minusNumber);
    }
}

function submits() {

    let $asdf = $('[data-td="checked"]');
    var $prices = [];
    var $skuids = [];
    var $numbers = [];

    $asdf.each(function () {
        if ($(this).prop("checked") == true){

            let $price = $(this).attr("data-price");
            let $skuid = $(this).attr("data-skuid");
            let $number = $(this).parent().siblings($('#tbody-tr-td-3')).find("input").val();

            $prices.push($price);
            $skuids.push($skuid);
            $numbers.push($number);

        };

    });
    let skuId = JSON.stringify($skuids);
    let pricess = JSON.stringify($prices);
    let numberss = JSON.stringify($numbers);

    // console.log(skuId)
    // console.log(pricess)
    // console.log(numberss)


    $.ajax({
        url:"/cart/number",
        data:{
            skuId: skuId,
            price: pricess,
            number: numberss
        },
        success: function (retult) {
            window.location.href="/checkout";
        }
    })






}