function LQScore(param) {
    this.tips = param.tips;//提示
    this.score = 0;//分数
    this.afterScore = param.afterScore;//评分结束后执行
    this.isScoreFinish = false;
    this.liContent="❤";
    this.init = function () {
        var obj = this;
        var tips = this.tips;
        var afterScore = this.afterScore;
        $("div.lq-score").append($("<ul></ul>"));
        for(var i=0;i<5;i++){
            $("div.lq-score>ul").append($("<li>"+obj.liContent+"</li>"));
        }
        $("div.lq-score>ul>li").addClass("lq-score-unselect");
        $("div.lq-score>ul>li").on("mouseover", function () {
            if (obj.isScoreFinish) { return; }
            $(this).prevAll("li").add(this).removeClass("lq-score-mouseover-c1 lq-score-mouseover-c2 lq-score-mouseover-c3 lq-score-mouseover-c4 lq-score-mouseover-c5 lq-score-unselect")
            $(".lq-score-tip").removeClass("lq-score-mouseover-c1 lq-score-mouseover-c2 lq-score-mouseover-c3 lq-score-mouseover-c4 lq-score-mouseover-c5 lq-score-unselect");
            var len = $(this).prevAll("li").add(this).length;
            $(this).prevAll("li").add(this).addClass("lq-score-mouseover-c" + len);
            $(".lq-score-tip").html(tips[len - 1]).addClass("lq-score-mouseover-c" + len);
        });
        $("div.lq-score>ul>li").on("mouseout", function () {
            if (obj.isScoreFinish) { return; }
            $(this).prevAll("li").add(this).removeClass("lq-score-mouseover-c1 lq-score-mouseover-c2 lq-score-mouseover-c3 lq-score-mouseover-c4 lq-score-mouseover-c5").addClass("lq-score-unselect");
            $(".lq-score-tip").html("");
        });
        $("div.lq-score>ul>li").on("click", function () {
            if (obj.isScoreFinish) { return; }
            $(this).parent().children("li").removeClass("lq-score-mouseover-c1 lq-score-mouseover-c2 lq-score-mouseover-c3 lq-score-mouseover-c4 lq-score-mouseover-c5 lq-score-unselect lq-score-select-c1 lq-score-select-c2 lq-score-select-c3 lq-score-select-c4 lq-score-select-c5");
            $(".lq-score-tip").removeClass("lq-score-mouseover-c1 lq-score-mouseover-c2 lq-score-mouseover-c3 lq-score-mouseover-c4 lq-score-mouseover-c5 lq-score-unselect lq-score-select-c1 lq-score-select-c2 lq-score-select-c3 lq-score-select-c4 lq-score-select-c5");
            var len = $(this).prevAll("li").add(this).length;
            $(this).prevAll("li").add(this).addClass("lq-score-select-c" + len);
            $(".lq-score-tip").html(tips[len - 1]).addClass("lq-score-select-c" + len);
            obj.score = len;
            $(this).nextAll("li").addClass("lq-score-unselect");
            obj.isScoreFinish = true;
            if (afterScore != null) {
                afterScore(obj.score);
            }
        });
    }
    this.setScore = function (score,isHandleAfterScore) {
        if (score > 5) {
            score = 5;
        } else if (score < 0) {
            score = 0;
        }
        this.score = score;
        $("div.lq-score>ul").children("li").removeClass("lq-score-mouseover-c1 lq-score-mouseover-c2 lq-score-mouseover-c3 lq-score-mouseover-c4 lq-score-mouseover-c5 lq-score-unselect lq-score-select-c1 lq-score-select-c2 lq-score-select-c3 lq-score-select-c4 lq-score-select-c5");
        $(".lq-score-tip").removeClass("lq-score-mouseover-c1 lq-score-mouseover-c2 lq-score-mouseover-c3 lq-score-mouseover-c4 lq-score-mouseover-c5 lq-score-unselect lq-score-select-c1 lq-score-select-c2 lq-score-select-c3 lq-score-select-c4 lq-score-select-c5");
        if (score != 0) {
            $("div.lq-score>ul").children("li").slice(0, score).addClass("lq-score-select-c" + score);
            $(".lq-score-tip").html(this.tips[score - 1]).addClass("lq-score-select-c" + score);
            $("div.lq-score>ul").children("li").slice(score, 5).addClass("lq-score-unselect");
        }
        this.isScoreFinish = true;
        if (this.afterScore != null&&isHandleAfterScore) {
            this.afterScore(score);
        }
    }
}