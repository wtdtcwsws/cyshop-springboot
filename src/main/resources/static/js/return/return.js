// 加数量事件
function addNumber(add) {
    let $this = $(add);
    // 获取数量的标签
    let $number = $this.prev($('[data-js="number"]'));
    // 原有基础上+1
    let num = Number($number.val()) + Number(1);
    // 操作反馈
    $number.val(num);
}

// 减数量事件
function minusNumber(minus) {
    let $this = $(minus);
    // 获取数量的标签
    let $number = $this.next($('[data-js="number"]'));
    // 进行判断原有数量，如果小于等于0那么不进行操作
    if($number.val() > 1){
        // 原有基础上-1
        let num = Number($number.val()) - Number(1);
        // 操作反馈
        $number.val(num);
    }
}

// 提交事件
function clicks(submit) {
    let $this = $(submit);

    // 服务类型
    let $option = $('[data-js="option"]').val();
    // 提交原因
    let $options = $('[data-js="options"]').val();
    // 问题描述
    let $textarea = $('[data-js="textarea"]').val();
    // 选择数量
    let $number = $('[data-js="number"]').val();
    // 商品单价
    let $price = $('[data-js="price"]').text();
    // 获取商品订单id
    let $orderid = $('#order').attr('data-orderid');
    // 获取skuid
    let $skuid = $('#order').attr('data-skuid');
    // 获取商品总价
    let $numbers = Number($number) * Number($price);

    let Soption = JSON.stringify($option);
    let Soptions = JSON.stringify($options);
    let Stextarea = JSON.stringify($textarea);
    let Snumber = JSON.stringify($number);
    let Sprice = JSON.stringify($price);
    let Sorderid = JSON.stringify($orderid);
    let Sskuid = JSON.stringify($skuid);
    let Snumbers = JSON.stringify($numbers);

    $.ajax({

        url:"/return/transfer",
        data:{
            option: Soption,
            options: Soptions,
            textarea: Stextarea,
            number: Snumber,
            price: Sprice,
            orderid: Sorderid,
            skuid: Sskuid,
            numbers: Snumbers
        },
        success: function (result) {
            if (result == "true"){
                bootbox.alert({
                    title: "提示",
                    message: "商品退/换货订单提交成功！点击确定跳转到主页！",
                    backdrop: false,
                    callback: function (result) {
                        if (result == true){
                        }else {
                            window.location.href="/index.html";
                        }
                    }
                });
            }else{
                bootbox.alert({
                    title: "提示",
                    message: "出现未知错误！",
                    backdrop: false
                });
            };
        }
    });




}
