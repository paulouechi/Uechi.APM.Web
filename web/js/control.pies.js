$(document).ready(function () {
    window.cf_DefaultPieOpts = {};
    cf_DefaultPieOpts.segmentShowStroke = false;
    $('.cf-pie').each(function () {
        var pdata = [
            {   value: 40,
                color: pieSegColors[3],
                label: 'Livre'
            },
            {   value: 120,
                color: pieSegColors[1],
                label: 'Usado'
            }
        ]
        var $container = $(this);
        var pId = $container.prop('id');
        cf_rPs[pId] = {};
        cf_rPs[pId].data = pdata;
        createPieChart($container);
    });
});

function createPieChart(obj) {
    $(window).resize(generatePieChart);
    function generatePieChart() {
        $container = obj;
        pId = $container.prop('id');
        var $canvas = $('canvas', $container);
        var cWidth = $container.width() * 0.50;
        var cHeight = $container.height();
        if (cHeight == 0) {
            cHeight = cWidth - 28;
        }
        $canvas.prop({width: cWidth, height: cHeight});
        var ctx = $canvas.get(0).getContext('2d');
        var pieOptions;
        if (cf_rPs[pId].options) {
            var pieOptions = $.extend({}, cf_DefaultPieOpts, cf_rPs[pId].options);
        }
        else {
            pieOptions = cf_DefaultPieOpts;
        }
        new Chart(ctx).Pie(cf_rPs[pId].data, pieOptions);
        createPieLegend(pId);
    }

    function createPieLegend(pId) {
        if (cf_rPs[pId].legend) {
            $('#' + pId).append(pieLegendHtml);
        }
        else {
            var pieLegendRow = '';
            var pieLegendHtml = '';
            for (i in cf_rPs[pId].data) {
                pieLegendRow += '<li><div class="cf-pie-legend-color" style="background-color:' + cf_rPs[pId].data[i].color + '"></div>' + cf_rPs[pId].data[i].label + '</li>';
            }
            pieLegendHtml += '<div class="cf-pie-legend"><ul>' + pieLegendRow + '</ul></div>';
            $('#' + pId).append(pieLegendHtml);
            cf_rPs[pId].legend = pieLegendHtml;
        }
    }
    generatePieChart();
}