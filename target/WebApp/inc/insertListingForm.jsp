<%--
  Created by IntelliJ IDEA.
  User: panos
  Date: 1/10/2017
  Time: 8:43 μμ
  To change this template use File | Settings | File Templates.
--%>
<div class="js-new-listing-form new-listing-form">

    <button data-fancybox data-src="#popup-holder" class="attention-button js-new-listing">Insert New Listing ( admin action )</button>
    <div id="popup-holder" style="display:none">
    <h2>Insert new listing</h2>
    <form name="NewListing" class="new-listing-form js-new-listing-form">
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <div class="part part-one">
            <div class="title">Location Information</div>
            <div class="form-row">
            Name: <br><input  class="form-input" type="text" name="name"> <br>
            </div>
            <div class="form-row">
            Url: <br><input type="text" class="form-input" name="listing_url" > <br>
            </div>
            <div class="form-row">
            Country: <br><input type="text" class="form-input" name="country" > <br>
            </div>
            <div class="form-row">
                State: <br><input type="text" class="form-input" name="state" > <br>
            </div>
            <div class="form-row">
            City: <br><input type="text" class="form-input" name="city" > <br>
            </div>
            <div class="form-row">
            Zip Code: <br><input type="text" class="form-input" name="zipcode" > <br>
            </div>
            <div class="form-row">
            Neighborhood Name: <br><input type="text" class="form-input" name="neighborhood_cleansed" > <br>
            </div>
        </div>

        <div class="part part-two">
            <div class="title">Pricing Details</div>

            <div class="form-row">
                Daily Price: <br><input type="text" class="form-input" name="price"> <br>
            </div>
            <div class="form-row">
            Weekly Price: <br><input type="text" class="form-input" name="weekly_price"> <br>
            </div>
            <div class="form-row">
            Monthly Price: <br><input type="text" class="form-input" name="monthly_price"> <br>
            </div>
            <div class="form-row">
            Security Deposit: <br><input type="text" class="form-input" name="security_deposit"> <br>
            </div>
            <div class="form-row">
            Cleaning fee: <br><input type="text" class="form-input" name="cleaning_fee"> <br>
            </div>
            <div class="form-row">
            Guests Included: <br><input type="text" class="form-input" name="guests_included"> <br>
            </div>
            <div class="form-row">
            Price per extra person: <br><input type="text" class="form-input" name="extra_people"> <br>
            </div>
        </div>
            <div class="part part-three">
                <div class="title">Reservation Details</div>

                <div class="form-row">
                    Minimum nights: <br><input type="text" class="form-input" name="minimum_nights"> <br>
                </div>
                <div class="form-row">
                    Maximum nights: <br><input type="text" class="form-input" name="maximum_nights"> <br>
                </div>
                <div class="form-row">
                    Cancellation policy :<br><input type="text" class="form-input" name="cancellation_policy"> <br>
                </div>
            </div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <div class="part part-four">
            <div class="title">Property details</div>
            <div class="form-row">
                Property Type: <br><input type="text" class="form-input" name="property_type"> <br>
            </div>
            <div class="form-row">
                Room Type: <br><input type="text" class="form-input" name="room_type"> <br>
            </div>
            <div class="form-row">
                Accommodates: <br><input type="text" class="form-input" name="accommodates"> <br>
            </div>
            <div class="form-row">
                Bathrooms: <br><input type="text" class="form-input" name="bathrooms"> <br>
            </div>
            <div class="form-row">
                Bedrooms: <br><input type="text" class="form-input" name="bedrooms"> <br>
            </div>
            <div class="form-row">
                Beds: <br><input type="text" class="form-input" name="beds"> <br>
            </div>
            <div class="form-row">
                Bed Type: <br><input type="text" class="form-input" name="bed_type"> <br>
            </div>
            <div class="form-row">
                Surface (square feet): <br><input type="text" class="form-input" name="square_feet"> <br>
            </div>
            <div class="form-row">
                Amenities: <br><textarea type="text" class="form-input" name="amenities"></textarea> <br>
            </div>
            <div class="form-row">
                Summary: <br><textarea type="text" class="form-input" name="summary"></textarea> <br>
            </div>
            <div class="form-row">
                Space Info: <br><textarea type="text" class="form-input" name="space"></textarea> <br>
            </div>
            <div class="form-row">
                Description: <br><textarea type="text" class="form-input" name="description"></textarea> <br>
            </div>
            <div class="form-row">
                Neighborhood Overview: <br><textarea type="text" class="form-input" name="neighborhood_overview"></textarea> <br>
            </div>
            <div class="form-row">
                Notes: <br><textarea type="text" class="form-input" name="notes"></textarea> <br>
            </div>
            <div class="form-row">
                Transit: <br><textarea type="text" class="form-input" name="transit"></textarea> <br>
            </div>
        </div>

        </div>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 message"></div>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <button type="button" class="attention-button js-new-listing-submit">Eisagwgi</button>
        </div>


    </form>
    </div>

</div>