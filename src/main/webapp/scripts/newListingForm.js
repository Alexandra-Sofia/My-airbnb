$(document).ready(function(){

    var $wrapper = $('.js-new-listing-form');

    if($wrapper.length < 1)
        return;

    $('.js-new-listing', $wrapper).fancybox();

    var formData = {
        host_id: $wrapper.data('user-id')
    };


    $wrapper.on('keyup','input,textarea', function(){

        var $this = $(this),
            fieldName = $this.attr('name');

        formData[fieldName] = $this.val();

    });

    $wrapper.on('click','.js-new-listing-submit',function(){
        $('.message', $wrapper).html('').removeClass('success error');
        if(!formData['name'] || !formData['space'] || !formData['description']){
            $('.message', $wrapper).html('You can\'t leave empty the values of name, space and description ').addClass('error');
        }else{
            console.log(formData);
            $.ajax({
                url:"listingRequest",
                method:"post",
                data:formData,
                success:function(result){
                    if(result=="SUCCESS") {
                        $('.message', $wrapper).html('New listing added').addClass('success');
                    }
                    else {
                        $('.message', $wrapper).html('Something went wrong... Try again').addClass('error');
                    }
                },
                error: function(){
                    $('.message', $wrapper).html('Something went wrong... Try again').addClass('error');
                }
            });



        }


    });


});