/**
 * lq-score
 * @author LQresier
 */
(function ($) {
    var LQScore = function (ele, options) {
        this.$element = ele;
        this.defaults = {
            $tipEle:null,
            fontSize:"20px",//大小
            isScoreFinish:false,//评分是否结束
            tips: [],//提示
            zeroTip:"",//无分数提示
            score: 0,//分数
            afterScoreHandler: null,//评分后处理
            liContent: "❤",//内容
            defultColor:"#ccc",//默认颜色
            mouseoverColor:["rgb(91, 91, 255)","rgb(72, 121, 72)","rgb(255, 231, 95)","rgb(255, 199, 94)","rgb(255, 71, 71)"],//鼠标经过的颜色
            selectColor:["rgb(53, 53, 255)","green","rgb(255, 238, 0)","orange","red"]//选中后的颜色
        };
        this.options = $.extend({}, this.defaults, options)
    }
    LQScore.prototype = {
        // 初始化评分插件
        init: function () {
            var obj=this;
            var $tipEle=obj.options.$tipEle;
            obj.$element.addClass("lq-score");
            obj.$element.append($("<ul></ul>"));
            var $ulEle=obj.$element.children("ul").eq(0);
            for (var i = 0; i < 5; i++) {
                $ulEle.append($("<li style='font-size:"+obj.options.fontSize+";padding:0 2px;'>" + obj.options.liContent + "</li>"));
            }
            var $liEle=$ulEle.children("li");
            $liEle.css("color",obj.options.defultColor);
            if($tipEle!=null){
                $tipEle.html(obj.options.zeroTip).css("color",obj.options.defultColor);
            }
            obj.options.score=Math.round(obj.options.score);
            if(obj.options.score<0||obj.options.score>5){
                throw new Error("score 超出范围");
            }else if(obj.options.isScoreFinish==true){
                this.setScore();
            }
            $liEle.on("mouseover", function () {
                if (obj.options.isScoreFinish) { return; }
                var len = $(this).prevAll("li").add(this).length;
                $(this).prevAll("li").add(this).css("color",obj.options.mouseoverColor[len-1]);
                $tipEle.html(obj.options.tips[len - 1]).css("color",obj.options.mouseoverColor[len-1]);
            });
            $liEle.on("mouseout", function () {
                if (obj.options.isScoreFinish) { return; }
                $(this).prevAll("li").add(this).css("color",obj.options.defultColor);
                $tipEle.html(obj.options.zeroTip).css("color",obj.options.defultColor);
            });
            $liEle.on("click", function () {
                if (obj.options.isScoreFinish) { return; }
                var len = $(this).prevAll("li").add(this).length;
                $(this).prevAll("li").add(this).css("color",obj.options.selectColor[len-1]);
                if($tipEle!=null){
                    $tipEle.html(obj.options.tips[len - 1]).css("color",obj.options.selectColor[len-1]);
                }
                obj.options.score = len;
                $(this).nextAll("li").css("color",obj.options.defultColor);
                obj.options.isScoreFinish = true;
                $liEle.css("cursor","default");
                if (obj.options.afterScoreHandler != null) {
                    obj.options.afterScoreHandler(obj.$element,obj.options.score);
                }
            });
            return this.$element;
        },
        setScore:function(){
            var $liEle=this.$element.children("ul").children("li");
            $liEle.css("cursor","default");
            if(this.options.score==0){
                if(this.options.$tipEle!=null){
                    this.options.$tipEle.html(this.options.zeroTip).css("color",this.options.defultColor);
                }
                return;
            }
            $liEle.slice(0, this.options.score).css("color",this.options.selectColor[this.options.score-1]);
            if(this.options.$tipEle!=null){
                this.options.$tipEle.html(this.options.tips[this.options.score - 1]).css("color",this.options.selectColor[this.options.score-1]);
            }
            if (this.options.afterScoreHandler != null) {
                this.options.afterScoreHandler(this.$element,this.options.score);
            }
        }
    }
    $.fn.lqScore = function (options) {
        var lqScore = new LQScore(this, options);
        return lqScore.init();
    }
})(jQuery);