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
        $('[data-tr="checked"]').css('background-color',color);
    };
    if (checks.checked == false){
        $('[data-td="checked"]').prop("checked",false);
        $('[data-tr="checked"]').css('background-color',colors);
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
    // 获取数量标签
    let $number = $this.siblings($('[role="group"]')).children($('[data-js="number"]'));
    // 获取商品单价
    let $price = $this.parent().parent($('[data-td="number"]')).prev($('[data-price="price"]')).attr('data-prices');
    console.log($price);
    // 获取商品小计标签
    let $allPrice = $this.parent().parent($('[data-td="number"]')).next($('[data-js="allPrice"]'));
    // 将操作后的数量赋值
    $number.val(numberAdd);
    // 商品小计的数目
    let $allNumber = ($price * $number.val()).toFixed(2);
    // 商品小计数目放入标签中
    $allPrice.text('￥' + $allNumber);
};

// 减少数量
function minusNumber(number) {
    let $this = $(number);
    // 获取数量input中的数字
    let numbers = Number($this.parent().find('input').val());
    // 获取减数量的所在行的复选框
    let check = $this.parent().parents().siblings($('[data-js="selects"]')).children($('[data-td="checked"]'));
    // 点击减数量的时候复选框点选以及背景色显示
    check.prop("checked", true);
    $this.parent().parent().parent().css('background-color', color);
    // 判断数量，数量小于1的时候不进行操作
    if (numbers > 1) {
        // 操作反馈,减少数量
        let minusNumber = numbers - Number(1);
        // 获取数量标签
        let $number = $this.siblings($('[role="group"]')).children($('[data-js="number"]'));
        // 获取商品单价
        let $price = $this.parent().parent($('[data-td="number"]')).prev($('[data-price="price"]')).attr('data-prices');
        // 获取商品小计标签
        let $allPrice = $this.parent().parent($('[data-td="number"]')).next($('[data-js="allPrice"]'));
        // 将操作后的数量赋值
        $number.val(minusNumber);
        // 商品小计的数目
        let $allNumber = ($price * $number.val()).toFixed(2);
        // 商品小计数目放入标签中
        $allPrice.text('￥' + $allNumber);
    }
}

// 提交按钮事件
function submits() {
    // 声明单选框，单价的数组，skuid的数组，用户选择后数量的数组
    let $asdf = $('[data-td="checked"]');
    var $prices = [];
    var $skuids = [];
    var $numbers = [];
    // 将复选框迭代查询，如果为选中状态（true）那么久获取需要的信息
    $asdf.each(function () {
        if ($(this).prop("checked") == true){
            let $price = $(this).attr("data-price");
            let $skuid = $(this).attr("data-skuid");
            let $number = $(this).parent().siblings($('#tbody-tr-td-3')).find("input").val();
            // 将获取的信息添加到前面声明的数组当中
            $prices.push($price);
            $skuids.push($skuid);
            $numbers.push($number);
        };
    });
    // 将获取的数组封装成json数据
    let skuId = JSON.stringify($skuids);
    let pricess = JSON.stringify($prices);
    let numberss = JSON.stringify($numbers);
    // 发送数据到控制器
    $.ajax({
        url:"/cart/number",
        data:{
            skuId: skuId,
            price: pricess,
            number: numberss
        },
        success: function (retult) {
            if (retult == "true"){
                window.location.href="/checkout";
            }else{
                // window.alert("请选择商品！");
                bootbox.alert({
                    title: "提示",
                    message: "请选择商品！",
                    backdrop: false
                });
            };
        },
    });
};

// 关注按钮事件
function attention(attention) {
    bootbox.alert({
        title: "提示",
        message: "加入关注成功！",
        backdrop: false
    });

}