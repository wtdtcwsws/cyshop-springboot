(function () {

    $(document).ready(function () {
        let $paymentId = $('#myTabContent').attr('data-payment');
        if ($paymentId=='1'){
            $('#wxPayment').addClass('active');
            $('#home').addClass('active in');
        }else{
            $('#zfbPayment').addClass('active');
            $('#ios').addClass('active in');
        }
    });

    // $('#peymentForm').validate({
    //     errorElement:'span',
    //     errorPlacement:function(error,input){
    //         input.parent().next().append(error);
    //     },
    //     rules:{
    //         paymentPassword:{
    //             required:true
    //         }
    //     },
    //     messages:{
    //         paymentPassword:{
    //             required:'<i class="fa fa-remove" style="color: red"></i>请输入支付密码'
    //         }
    //     }
    //
    // });



})(jQuery);