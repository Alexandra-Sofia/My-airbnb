$(document).ready(function(){

    var $wrapper = $('#search-box-home');

    if($wrapper.length < 1) return;


    var formData = {
        location: $('[name="location"]', $wrapper).val() || "",
        dateFrom: '',
        dateTo: '',
        visitors: $('[name="visitors"]', $wrapper).val() || ""
    }

    $wrapper.on('click','.js-search-btn', function(e){
        //e.preventDefault();
        console.log(formData);
    });

    InitDatePicker();
    function InitDatePicker() {

        var year = new Date().getFullYear(),
            yearRange = year-2 + ":" + year+1;

        $('#dateFrom').datepicker({
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            yearRange: yearRange,
            minDate: "1",
            maxDate: "365",
            //yearRange: '-100',
            onSelect: function () {
                //formData['birthday'] = $('.birthday-calendar').datepicker("getDate");
                //console.log(formData['birthday']);
                formData['dateFrom'] = $('input[name="dateFrom"]', $wrapper).val();
                //console.log(formData['birthday']);
            },
        });
        $('#dateTo').datepicker({
            changeMonth: true,
            changeYear: true,
            dateFormat: 'dd/mm/yy',
            yearRange: yearRange,
            minDate: "1",
            maxDate: "365",
            //yearRange: '-100',
            onSelect: function () {
                //formData['birthday'] = $('.birthday-calendar').datepicker("getDate");
                //console.log(formData['birthday']);
                formData['dateTo'] = $('input[name="dateTo"]', $wrapper).val();
                //console.log(formData['birthday']);
            },
        });

        $('#dateTo,#dateFrom').keyup(function (e) {
            if (e.keyCode == 8 || e.keyCode == 46) {
                $.datepicker._clearDate(this);
            }
        });


    }

    $('input,select', $wrapper).on('keyup change',function(){
        var field = $(this).attr('name');
        formData[field]=$(this).val();
    });
    //$('input,select', $wrapper).on('keyup,change',function(){
        //    var field = $(this).attr('name');
        //    formData[field]=$(this).val();
        //});

});