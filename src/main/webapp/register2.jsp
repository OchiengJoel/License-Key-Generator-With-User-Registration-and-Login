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
              <h2>Welcome To Account Sign Up</h2>
              <p>Have an account?</p>
              <a href="index2.jsp" class="btn btn-white btn-outline-white">Login</a>
            </div>
          </div>
          <div class="login-wrap p-4 p-lg-5">
            <div class="d-flex">
              <div class="w-100">
                <h4 class="mb-4">Create Account</h4>
              </div>
              <div class="w-100">
                <p class="social-media d-flex justify-content-end">
                  <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-facebook"></span></a>
                  <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a>
                </p>
              </div>
            </div>
            <form action="ServletRegister" class="signin-form" method="post">

              <div class="form-group mb-3">
                <label class="label" name="name">Full Names</label>
                <input type="text" name="name" class="form-control" placeholder="Enter Full Names" required value="<%
                String name = (String) request.getParameter("name");if (name != null) {out.print(name);}%>" >
                <%String nameMSG = (String) request.getAttribute("nameMSG"); if (nameMSG != null) { out.print(nameMSG);} %>
              </div>

              <div class="form-group mb-3">
                  <label class="label" name="email">Email Id</label>
                  <input type="text" name="email" class="form-control" placeholder="Enter Your Email" required value="<%
                  String email = (String) request.getParameter("email"); if (email != null) {out.print(email);}%>">
                  <% String emailMSG1 = (String) request.getAttribute("emailMSG1");
                     String emailMSG2 = (String) request.getAttribute("emailMSG2");
                                          if (emailMSG1 != null) { out.print(emailMSG1);}
                                          if (emailMSG2 != null) { out.print(emailMSG2);}%>
              </div>

              <div class="form-group mb-3">
                <label class="label" name="password">Password</label>
                <input type="password" name="password" class="form-control" placeholder="Enter Your Gmail Password" required value="<%
                String password = (String) request.getParameter("password"); if (password != null) {out.print(password);}%>">
                <% String passwordMSG = (String) request.getAttribute("passwordMSG"); if (passwordMSG != null) { out.print(passwordMSG); }%>
              </div>

              <div class="form-group mb-3">
                  <label class="label" name="role">Password</label>
                  <input type="text" name="role" class="form-control" placeholder="Enter User Role" required value="">
              </div>

              <div class="form-group">
                <button type="submit" class="form-control btn btn-primary submit px-3" value="">Sign Up</button> &nbsp &nbsp &nbsp  &nbsp  &nbsp
                <button type="reset" class="form-control btn btn-primary submit px-3">Reset</button>
              </div>
              <div class="form-group d-md-flex">
                <div class="w-50 text-left">
                  <label class="checkbox-wrap checkbox-primary mb-0">Remember Me
                    <input type="checkbox" checked>
                    <span class="checkmark"></span>
                  </label>
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

