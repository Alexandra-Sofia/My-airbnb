/**
 * Created by alex on 18/6/2017.
 */
$(document).ready(function() {
    $(".loginbutton").fancybox({
        // Options will go here
    });
});
function draw_map(){

    var displayItems = $('[data-map-coordinates]');
    var $map;
    displayItems.each(function(index,item){
        var coordinates = {lat: parseFloat($(item).data('latitude')), lng: parseFloat($(item).data('longitude'))} ,
            info = $('.info-synopsis',$(item)),
            name = $('.name',info).html();

        if(index==0){
            $('#map').addClass('visible');
            $map= new google.maps.Map(document.getElementById('map'), {
                zoom: 13,
                center: coordinates
            });
        }

        var marker = new google.maps.Marker({
          position: coordinates,
          map: $map,
          title: name
        });

        var infowindow = new google.maps.InfoWindow({
                  content: info.html()
                });

        marker.addListener('click', function() {
          infowindow.open(map, marker);
        });

    });


}

