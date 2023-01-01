<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
  <title>Login 07</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

  <link rel="stylesheet" href="css/style2.css">

</head>
<body>
<section class="ftco-section">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6 text-center mb-5">
        <h2 class="heading-section"></h2>
        <p>Welcome Back, <b><%= ((String) session.getAttribute("loginUser")).toUpperCase() %>.....</b></p>
            <%-- <p>Your email address is: <%= session.getAttribute("loginUser") %></p> --%>
           <%-- <p>License key: <%= license.getKey() %></p>--%>
           <%--  <p>Expiration date: <%= dateFormat.format(license.getExpirationDate()) %></p> --%>
           <%-- <%= request.getAttribute("license") %> --%>

      </div>
    </div>
    <div class="row justify-content-center">
      <div class="col-md-12 col-lg-10">
        <div class="wrap d-md-flex">
          <div class="text-wrap p-4 p-lg-3 text-center align-items-center order-md-last">
            <div class="text w-100">
              <h2>Generated License Keys</h2>
              <%-- <p>Have an account?</p> --%>
              <%-- <a href="logout" class="btn btn-white btn-outline-white">Logout</a> --%>

              <table class="table table-striped">
                  <thead>
                  <tr>
                    <th scope="col">License Key</th>
                    <th scope="col">Link</th>
                    <th scope="col">Days</th>
                    <th scope="col">Expiry Date</th>
                  </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${licenseList}" var="item">
                      <tr>
                        <td>${item.lkey}</td>
                        <td>${item.link}</td>
                        <td>${item.days}</td>
                        <td>${item.expiration_date}</td>
                      </tr>
                    </c:forEach>

                  </tbody>
              </table>

            </div>
          </div>
          <div class="login-wrap p-4 p-lg-5">
            <div class="d-flex">
              <div class="w-100">
                <h5 class="mb-4">Generate License</h5>
              </div>
              <div class="w-100">
                <p class="social-media d-flex justify-content-end">
                  <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-facebook"></span></a>
                  <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a>
                </p>
              </div>
            </div>
            <form action="GenerateLicenseKeyServlet" class="signin-form" method="get">

              <div class="form-group mb-3">
                <label class="label">Enter Link</label>
                <input type="url" class="form-control" placeholder="Enter Valid Http(s) Url" id="link" name="link" required >
              </div>

              <div class="form-group mb-3">
                  <label class="label">No. Of Days</label>
                  <input type="number" class="form-control" placeholder="Enter Number Of Days" id="days" name="days" required>
              </div>

              <div class="form-group">
                <button type="submit" class="form-control btn btn-primary submit px-3" value="">Generate License Key</button> &nbsp &nbsp &nbsp  &nbsp  &nbsp
                <button type="reset" class="form-control btn btn-primary submit px-3">Reset</button>
              </div>
            </form>
          <div>
          <div>
          </div>

          </div>


          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>



            	String link = request.getAttribute("link");
            	if (link != null) {

            	<p>Generated Link:=link</p>

            	}

</body>
</html>

