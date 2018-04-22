/**
 * Created by alex on 15/5/2017.
 */
var dateOfArrival = '',
    dateOfDepart = '';
$(document).ready(function(){

    var $wrapper = $('.js-book-box');

    if ($wrapper.length < 1)
        return;

    $('.js-book-button[data-fancybox]').fancybox();



    $wrapper.on('click','.js-book-date',function(){

        var $this = $(this),
            year = $this.data('year'),
            month = $this.data('month'),
            day = $this.data('day'),
            tempDate = year+"-"+month+"-"+day;

        if($this.hasClass('selected-date')){
            if($this.hasClass('departure')){
                dateOfDepart = '';
            }else{
                dateOfArrival = '';
            }
            $this.removeClass('selected-date departure arrival');

        } else {

            if(!dateOfArrival){
                dateOfArrival =tempDate;
                $this.addClass('selected-date arrival');
            }else if(!dateOfDepart){
                if(getDiffInDays(dateOfArrival,tempDate)<0){
                    dateOfDepart = dateOfArrival;
                    dateOfArrival = tempDate;
                }else{
                    dateOfDepart = tempDate;
                }
            }else if(getDiffInDays(dateOfArrival,tempDate)<0){
                dateOfArrival = tempDate;
            }else if (getDiffInDays(dateOfDepart,tempDate)>0){
                dateOfDepart = tempDate;
            }else{
                var distArrival = getDiffInDays(dateOfArrival,tempDate),
                    distDepart = getDiffInDays(tempDate,dateOfDepart),
                    max = getDiffInDays(dateOfArrival,dateOfDepart);

                if(distArrival>distDepart){
                    dateOfDepart = tempDate;
                }else{
                    dateOfArrival = tempDate;
                }
            }
        }
        refreshSelected($wrapper);

    });

    $wrapper.on('click','.js-book-button',function(e){

        e.preventDefault();

        var $this = $(this),
            listingId = $wrapper.data('listing-id'),
            userId = $wrapper.data('user-id'),
            numOfDays=dateOfArrival && dateOfArrival ? getDiffInDays(dateOfArrival,dateOfDepart) : 0;

        if(numOfDays<0){
            var temp= dateOfDepart;
            dateOfDepart=dateOfArrival;
            dateOfArrival = temp;
            numOfDays = -numOfDays;
        }

        if(!dateOfArrival || !dateOfDepart || !numOfDays ) {
            inform('You should pick dates first...');
            return;
        }

        listingId = listingId && parseInt(listingId) ? parseInt(listingId) : -1;
        userId = userId && parseInt(userId) ? parseInt(userId) : -1;

        if(listingId == -1 || userId == -1) {
            inform('You should login before you try book dates for this listing');
        }else{
            var r = confirm('You are about to rent this listing \nfrom ' + dateOfArrival + ' to ' + dateOfDepart + ' ! \nAre you sure?\nOnce you make a reservation, \nyou can only cancel by contacting the host');
            if(r==true){
                var data = {
                    listingId:listingId,
                    userId:userId,
                    dateOfArrival:dateOfArrival,
                    dateOfDepart:dateOfDepart,
                    numOfDays:numOfDays
                };
                console.log(data);
                $.ajax({
                    url:"bookRequest",
                    method:"post",
                    data:data,
                    success:function(result){
                        if(result=="SUCCESS"){
                            inform('Successfully made a reservation for this listing \nfrom: ' + dateOfArrival +', to: ' + dateOfDepart, true);
                        } else if ( result == "NOT_AVAILABLE") {
                            inform('This listing isn\'t available for the time period you requested ( from: ' + dateOfArrival +', to: ' + dateOfDepart + ')' );
                        } else {
                            inform('Unable to make a reservation!\nPlease try again later...');
                        }
                    }
                });
            } else {
                inform('Booking Cancelled... Would you like to rethink your booking details?');
            }
        }



    });

    $wrapper.on('click','.js-clear',function(){
        clearDates();
        refreshSelected($wrapper);
    });

    function inform (message, option){
        var element = $('.js-message', $wrapper);
        if(option){
            element.removeClass('error').addClass('success');
        }else{
            element.removeClass('success').addClass('error');
        }
        element.html(message);
    }

    function getDiffInDays(date1,date2){

        var _MS_PER_DAY = 1000 * 60 * 60 * 24;
        var a    = new Date(date1);
        var b    = new Date(date2);

        var utc1 = Date.UTC(a.getFullYear(), a.getMonth(), a.getDate());
        var utc2 = Date.UTC(b.getFullYear(), b.getMonth(), b.getDate());

        var remainingDays = Math.floor((utc2 - utc1) / _MS_PER_DAY);

        return remainingDays;

    }

    function clearDates(){
        dateOfArrival='';
        dateOfDepart='';
    }
});
function refreshSelected($wrapper){
    if($wrapper.length < 1) return;
    $('.js-book-date',$wrapper).removeClass('selected-date arrival departure');
    if(dateOfArrival) {

        var parts = dateOfArrival.split('-'),
            element = $('.js-book-date[data-year="'+parts[0]+'"][data-month="'+parts[1]+'"][data-day="'+parts[2]+'"]', $wrapper),
            label = $('.js-selection .date-of-arrival',$wrapper);

        if(element.length){
            element.addClass('selected-date arrival');
        }
        label.html("Arriving at "+dateOfArrival);
    }else{
        var label = $('.js-selection .date-of-arrival',$wrapper);
        label.html("");
    }

    if(dateOfDepart) {

        var parts = dateOfDepart.split('-'),
            element = $('.js-book-date[data-year="'+parts[0]+'"][data-month="'+parts[1]+'"][data-day="'+parts[2]+'"]', $wrapper),
            label = $('.js-selection .date-of-departure',$wrapper);

        if(element.length){
            element.addClass('selected-date departure');
        }
        label.html("Departing at "+dateOfDepart);
    }else{
        var label = $('.js-selection .date-of-departure',$wrapper);
        label.html("");
    }
    var message = $('.js-message',$wrapper);
    message.removeClass('success error').html('');
}
