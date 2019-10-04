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
							<i class="fas fa-sign-in-alt"></i> Login
						</h1>
						<div>${message}</div>
						<form action="/users/login" method="POST">
							<div class="form-group">
								<label for="email">Email</label>
								<input type="email" id="email" name="email" class="form-control" placeholder="Enter Email" value="" />
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<input type="password" id="password" name="password" class="form-control" placeholder="Create Password" value="" />
							</div>
							<button type="submit" class="btn btn-primary btn-block"> Login </button>
						</form>

						<p class="lead mt-4">No Account? <a href="/users/register">Register</a></p>
					</div>
				</div>
			</div>
		  </div>
    </body>
</html>