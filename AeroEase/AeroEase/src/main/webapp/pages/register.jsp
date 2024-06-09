<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://kit.fontawesome.com/64d58efce2.js" cross
	origin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/register.css">

<title>Sign in & Sign up Form</title>
</head>

<%@ include file="/pages/header.jsp"%>
<body>
	<div class="container">
		<div class="forms-container">
			<div class="signin-signup">
				<form action="../LoginUser" method="post"  class="sign-in-form">
					<h2 class="title">Sign in</h2>
					<div class="input-field">
						<!-- 	<i class="fas fa-user"></i>  -->
						<input type="text" placeholder="Username" name="usernameLogin" />
					</div>
					<div class="input-field">
						<!-- 	<i class="fas fa-lock"></i> -->
						<input type="password" placeholder="Password" name="passwordLogin" />
					</div>
					<input type="submit" value="Login" class="btn solid" />
	<%String errMsg1 = (String) request.getAttribute(StringUtil.MESSAGE_ERROR_SIGNIN);
	String successMsg1 = (String) request.getAttribute(StringUtil.MESSAGE_SUCCESS_SIGNIN);

	if (errMsg1 != null) {
		// print
	%>
	<h4 class="error-msg1">
		<%
		out.println(errMsg1);
		%>
	</h4>
	<%
	}
	if (successMsg1 != null) {
	// print
	%>
	<h4 class="success-msg1">
		<%
		out.println(successMsg1);
		%>
	</h4>
	<%
	}
	%>				 


				</form>

					
				<form action="../RegisterUser" method="post" class="sign-up-form" enctype="multipart/form-data" >
					<h2 class="title">Sign up</h2>
					<div class="two-fields">
						<div class="input-field">
							<!-- <i class="fas fa-user"></i> -->
							<input type="text" placeholder="Username" name="userName" required />
						</div>
						<div class="input-field">
							<!-- <i class="fas fa-phone"></i>  -->
							<input type="text" placeholder="PhoneNumber" name="phoneNumber" required />
						</div>
					</div>
					<div class="two-fields">
						<div class="input-field">
							<!-- <i class="fas fa-user"></i>  -->
							<input type="text" placeholder="First Name" name="firstName"  required/>
						</div>
						<div class="input-field">
							<!-- 	<i class="fas fa-user"></i>  -->
							<input type="text" placeholder="Last Name" name="lastName" required />
						</div>
					</div>

					<div class="two-fields">
						<div class="input-field">
							<!-- <i class="fas fa-lock"></i>  -->
							<input type="password" placeholder="Password" name="password" required />
						</div>

						<div class="input-field">
							<!-- <i class="fas fa-lock"></i>  -->
							<input type="password" placeholder="Re-type Password"
								name="retypePassword" required/>

						</div>
					</div>
					<div class="input-field date">
						<label class="dob-label" for="date"> Date of Birth</label> <input
							type="date" id="DOB" placeholder="DOB" name="dob" required />

					</div>
					<div class="custom-file-input">
						<input type="file" id="imageInput" accept="image/*" name="image"> <label
							for="imageInput">Upload Profile Picture</label>
					</div>
					<div id="fileNameDisplay"></div>

					<script>
    // Get the file input element
    const fileInput = document.getElementById('imageInput');

    // Get the element where we want to display the filename
    const fileNameDisplay = document.getElementById('fileNameDisplay');

    // Add an event listener to the file input
    fileInput.addEventListener('change', function() {
        // Get the selected file
        const file = this.files[0];

        // Display the filename
        fileNameDisplay.textContent = file ? file.name : 'No file selected';
    });
</script>


					<input type="submit" class="btn" value="Sign up" />
					<%
		String errMsg = (String) request.getAttribute(StringUtil.MESSAGE_ERROR_SIGNUP);
		String successMsg = (String) request.getAttribute(StringUtil.MESSAGE_SUCCESS_SIGNUP);

		if (errMsg != null) {
			// print
		%>
		<h4 class="error-msg">
			<%
			out.println(errMsg);
			%>
		</h4>
		<%
		}

		if (successMsg != null) {
		// print
		%>
		<h4 class="success-msg">
			<%
			out.println(successMsg);
			%>
		</h4>
		<%
		}
		%>
				</form>
		
			</div>
		</div>

		<div class="panels-container">
			<div class="panel left-panel">
				<div class="content">
					<h3>NOT REIGSTERED?</h3>
					<p>Ready to fly with us? Sign in now for exclusive deals and
						seamless booking</p>
					<button class="btn transparent" id="sign-up-btn">Sign up</button>
				</div>

			</div>
			<div class="panel right-panel">
				<div class="content">
					<h3>ALREADY REIGSTERED?</h3>
					<p>Ready to fly with us? Sign up now for exclusive deals and
						seamless booking</p>
					<button class="btn transparent" id="sign-in-btn">Sign in</button>
				</div>

			</div>
		</div>
	</div>


    
	<script>
	const sign_in_btn = document.querySelector("#sign-in-btn");
	const sign_up_btn = document.querySelector("#sign-up-btn");
	const container = document.querySelector(".container");

	sign_up_btn.addEventListener("click", () => {
	  container.classList.add("sign-up-mode");
	});

	sign_in_btn.addEventListener("click", () => {
	  container.classList.remove("sign-up-mode");
	});
	
	
    var goTo = '<%=request.getAttribute("goTo")%>';
	if (goTo) {
		
		var element = document.getElementById(goTo);
		if (element) {
			element.scrollIntoView();
		}
	}
		
		</script>


</body>


</html>
