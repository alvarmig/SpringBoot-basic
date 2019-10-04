<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    	<link rel="stylesheet" href="https://bootswatch.com/4/journal/bootstrap.min.css">
        <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >-->
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">
        <title>Inicio de sesion</title>
    </head>
    <body>
		<div class="container">
			<div class="row mt-5">
				<div class="col-md-6 m-auto">
					<div class="card card-body">
						<h1 class="text-center mb-3">
							<i class="fas fa-user-plus"></i> Register
						</h1>
						
						<form action="/users/add" method="POST" class="registerForm">
							<div class="form-group">
								<label for="name">Name</label>
								<input type="name" id="name" name="name" class="form-control" placeholder="Enter Name" value=""/>
							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<input type="email" id="email" name="email" class="form-control" placeholder="Enter Email" value="" />
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<input type="password" id="password" name="password" class="form-control" placeholder="Create Password" value="" />
							</div>
							<div class="form-group">
								<label for="password2">Confirm Password</label>
								<input type="password" id="validatePassword" name="validatePassword" class="form-control" placeholder="Confirm Password" value="" />
							</div>
							<button type="submit" class="btn btn-primary btn-block"> Register </button>
						</form>

						<p class="lead mt-4">Have An Account? <a href="/users/login">Login</a></p>
					</div>
				</div>
			</div>
		  </div>
		  <script type="text/javascript" src="${pageContext.request.contextPath}/js/validations.js"></script>
    </body>
</html>