<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <div class="top-header">
        <div class="container">
            <div class="logo">
                <a href="index.html"><img src="<c:url value='/resources/images/logo.png' />"/></a>
            </div>
            <span class="menu"> </span>
            <div class="m-clear"></div>
            <div class="top-menu">
                <ul>
                    <li class="active" <c:url value='/index'/> >START</li>
                    <li><a class="scroll" href="<c:url value='/facilities' />" href="">FACILITIES</a></li>
                    <li><a class="scroll" href="<c:url value='/booking' />">BOOKING</a></li>
                    <li><a class="scroll" href="<c:url value='/contact' />">CONTACT US</a></li>
                </ul>
                <script>
                    $("span.menu").click(function () {
                        $(".top-menu ul").slideToggle(200);
                    });
                </script>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="banner">
        <div class="banner-info text-center">
            <h3><label>Hello,</label> You've Reached</h3>
            <h1>HOTEL FORTUNE</h1>
            <span></span>
            <div class="online_reservation">
                <div class="b_room">
                    <div class="booking_room">
                        <div class="reservation">
                            <!---strat-date-piker---->
                            <link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui.css' />"/>
                            <script src="<c:url value='/resources/js/jquery-ui.js' />"></script>
                            <script>
                                $(function () {
                                    $("#datepicker,#datepicker1").datepicker();
                                });
                            </script>
                            <!---/End-date-piker---->

                            <ul>
                                <li class="span1_of_1 left">
                                    <h5>Arrival</h5>
                                    <div class="book_date">
                                        <form>
                                            <span><img src="<c:url value='/resources/images/icon.png' />"
                                                       alt=""/></span>
                                            <input type="date" value="Select date" onfocus="this.value = '';"
                                                   onblur="if (this.value == '') {this.value = 'Select date';}">
                                        </form>
                                    </div>
                                </li>
                                <li class="span1_of_1 left">
                                    <h5>Departure</h5>
                                    <div class="book_date">
                                        <form>
                                            <span><img src="<c:url value='/resources/images/icon.png' />"
                                                       alt=""/></span>
                                            <input type="date" value="Select date" onfocus="this.value = '';"
                                                   onblur="if (this.value == '') {this.value = 'Select date';}">
                                        </form>
                                    </div>
                                </li>
                                <li class="span1_of_1">
                                    <h5>Room type</h5>
                                    <!----------start section_room----------->
                                    <div class="section_room">
                                        <label for="country"></label><select id="country"
                                                                             onchange="change_country(this.value)"
                                                                             class="frm-field required">
                                        <option value="null">Standard Single Room</option>
                                        <option value="null">Suite room</option>
                                        <option value="AX">Single room</option>
                                        <option value="AX">Double room</option>
                                    </select>
                                    </div>
                                </li>
                                <li class="span1_of_3">
                                    <div class="date_btn">
                                        <form>
                                            <input type="submit" value="View Prices"/>
                                        </form>
                                    </div>
                                </li>
                                <div class="clearfix"></div>
                            </ul>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</div>

