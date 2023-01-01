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
      </div>
    </div>
    <div class="row justify-content-center">
      <div class="col-md-12 col-lg-10">
        <div class="wrap d-md-flex">
          <div class="text-wrap p-4 p-lg-5 text-center d-flex align-items-center order-md-last">
            <div class="text w-100">
              <h2>Welcome To Login</h2>
              <p>Don't have an account?</p>
              <a href="register2.jsp" class="btn btn-white btn-outline-white">Sign Up</a>
              <br/>
              <a href="generatelicense.jsp" class="btn btn-white btn-outline-white">LKey</a>
            </div>
          </div>
          <div class="login-wrap p-4 p-lg-5">
            <div class="d-flex">
              <div class="w-100">
                <h3 class="mb-4">Sign In</h3>
              </div>
              <div class="w-100">
                <p class="social-media d-flex justify-content-end">
                  <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-facebook"></span></a>
                  <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a>
                </p>
              </div>
            </div>

            <%
            if (request.getAttribute("alreadyregister") != null) {
            String alreadyregister = (String) request.getAttribute("alreadyregister");
            out.print("<font style='color:red'>" + alreadyregister + "</font>");
            }
            if (request.getAttribute("register") != null) {
            String register = (String) request.getAttribute("register");
            out.print("<font style='color:red'>" + register + "</font>");
            }

            if (request.getAttribute("Error1") != null) {
            System.out.print(request.getAttribute("Error1"));
            String Error1 = (String) request.getAttribute("Error1");
            out.print("<font style='color:red'>" + Error1 + "</font>");

            }
            if (request.getAttribute("logout") != null) {
            System.out.print(request.getAttribute("logout"));
            String logout = (String) request.getAttribute("logout");
            out.print("<font style='color:navy'>" + logout + "</font>");
            }
            %>


            <form action="login" class="signin-form" method="post">
              <div class="form-group mb-3">
                <label class="label" name="email">Username</label>
                <input type="text" name="email" class="form-control" placeholder="Username" required>
              </div>
              <div class="form-group mb-3">
                <label class="label" name="password">Password</label>
                <input type="password" name="password" class="form-control" placeholder="Password" required>
              </div>

              <%-- <div class="form-group mb-3">
                <label class="label">Connection Settings</label>
                <input type="url" name="url" class="form-control" placeholder="https://ezen.tysons.co.ke/" required>
              </div> --%>
              <div class="form-group">
                <button type="submit" class="form-control btn btn-primary submit px-3" value="Sign in">Sign In</button>
              </div>
              <div class="form-group d-md-flex">
                <div class="w-50 text-md-left">
                  <a href="adminSignin.jsp">Admin Login</a>
                </div>
                <div class="w-50 text-md-right">
                  <a href="#">Forgot Password</a>
                </div>
              </div>
            </form>
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

</body>
</html>

