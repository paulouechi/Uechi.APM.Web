$(document).ready(function () {
    $('.cf-gauge').each(function () {
        var gId = $(this).prop('id');
        var gcId = $('canvas', $(this)).prop('id');
        var gmId = $('.metric', $(this)).prop('id');
        var ratio = 2.1;
        var width = $('.canvas', $(this)).width();
        var height = Math.round(width / ratio);
        $('canvas', $(this)).prop('width', width).prop('height', height);
        rGopts = {};
        rGopts.lineWidth = 0.30;
        rGopts.strokeColor = gaugeTrackColor;
        rGopts.limitMax = true;
        rGopts.colorStart = gaugeBarColor;
        rGopts.percentColors = void 0;
        rGopts.pointer = {
            length: 0.7,
            strokeWidth: 0.035,
            color: gaugePointerColor
        };
        cf_rGs[gId] = new Gauge(document.getElementById(gcId)).setOptions(rGopts);
        cf_rGs[gId].setTextField(document.getElementById(gmId));
        updateOpts = {'minVal': '0', 'maxVal': '100', 'newVal': varDataGauge[gId.replace("cf-gauge-", "")]};
        gaugeUpdate(gId, updateOpts);
        $(window).resize(function () {
            var ratio = 2.1;
            var width = $('.canvas', $('#' + gId)).width();
            var height = Math.round(width / ratio);
            cf_rGs[gId].ctx.clearRect(0, 0, width, height);
            $('canvas', $('#' + gId)).width(width).height(height);
            cf_rGs[gId].render();
        });
    });
});
