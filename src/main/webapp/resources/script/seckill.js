//存放主要交互逻辑 js代码

var seckill ={
    //封装秒杀相关ajax的url
    URL :{
        now:function () {
            return '/seckill/time/now';
        },
        exposer:function (seckillId) {
            return '/seckill/'+seckillId+'/exposer';
        },
        execution:function (seckillId,md5) {
            return '/seckill/'+seckillId+'/'+md5+'/execution';

        }
    },
    handleSeckillkill:function (seckillId,node) {
     //处理秒杀逻辑
        node.hide().html('<buttion class="btn btn-primary btn-lg" id="killBtn">开始秒杀</buttion>');
        $.post(
            seckill.URL.exposer(seckillId),
            {},
            function (result) {
                if(result && result['success']){
                    var exposer = result['data'];
                    if(exposer['exposed']){
                        //开启秒杀
                        var md5 = exposer['md5'];
                        var killUrl = seckill.URL.execution(seckillId,md5);
                        console.log("killUrl="+killUrl);
                        //绑定一次点击事件
                        $('#killBtn').one('click',function () {
                            //只ing秒杀请求
                            //1：先禁用按钮
                            $(this).addClass('disabled');
                            //2:发送秒杀请求
                            $.post(killUrl,{},function (result) {
                                if(result && result['success']){
                                    var killResult = result['data'];
                                    var state = result['state'];
                                    var stateInfo = killResult['stateInfo'];
                                    console.log(result);
                                    node.html('<span class="label label-success">'+stateInfo+'</span>');

                                }
                            },"json");

                        });
                        node.show();
                    }else{
                        //未开启秒杀
                        var now = exposer['now'];
                        var start = exposer['start'];
                        var end = exposer['end'];
                        //重新计算计时逻辑
                        seckill.countdown(seckillId,now,start,end);
                    }
                }

        });
    },
    //验证手机号
    validatePhone: function (phone) {

        if(phone && phone.length == 11 && !isNaN(phone)){
            return true;
        } else {
            return false;
        }

    },
    countdown: function (seckillId, nowTime, startTime, endTime) {
        var  seckillBox = $('#seckill-box');
        if (nowTime > endTime){
            //秒杀结束
            seckillBox.html('秒杀结束');
        }else if(nowTime < startTime){
            var killTime = new Date(startTime+1000);
            seckillBox.countdown(killTime,function (event) {
                //时间格式
                var format = event.strftime('秒杀倒计时：%D天 %H时 %M分 %S秒');
                seckillBox.html(format);
                //时间完成后回调事件
            }).on('finish.countdown',function () {
                //获取秒杀地址，执行秒杀
                seckill.handleSeckillkill(seckillId,seckillBox);
            });
        } else {
            //秒杀开始
            console.log("zenme huishi?");
            seckill.handleSeckillkill(seckillId,seckillBox);
        }
    },
    //秒杀详情页秒杀逻辑
    detail : {
        //详情页初始化
        init : function (params) {
            //手机验证登录，计时交互，在cookie中查找手机号
            var killPhone = $.cookie('killPhone');

            //验证手机号
            if (!seckill.validatePhone(killPhone)){
                //绑定phone，控制输出
                var killPhoneModal = $('#killPhoneModal');
                killPhoneModal.modal({
                    show:true,
                    backdrop:'static',//禁止位置关闭
                    keyboard:false,

                });
                $('#killPhoneBtn').click(function () {
                    var inputPhone = $('#killPhoneKey').val();
                    console.log('inputPhone='+inputPhone);
                    if(seckill.validatePhone(inputPhone)){
                        //写入电话，写入cookie
                        $.cookie('killPhone',inputPhone,{expires:7,path:'/seckill'});
                        //刷新页面
                        window.location.reload();
                    }else{
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
                    }
                });
            }
            //已经登陆，计时交互
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];
            $.get(
                seckill.URL.now(),
                {},
                function (result) {
                if(result && result['success']){
                    var nowTime = result['data'];
                    //时间判断
                   seckill.countdown(seckillId,nowTime,startTime,endTime)
                }else {
                    console.log('result:'+result);
                }
            });
        }
    }
}