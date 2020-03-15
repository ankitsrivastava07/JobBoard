function validateform() {

	var firstName = $("#firstName").val();
	var lastName = jQuery("#lastName").val();// document.getElementById("lastName").value;

	var email = $("#email").val();// document.getElementById("email").value;
	var password = $("#password").val();// document.getElementById("password").value;
	var emailFormat = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var mobileFormat = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	var state = $("#state").val();
	var mobile = $("#mobile").val();
	$(".error").remove();
	var valid = true;
	if (firstName == "") {
		$('#firstName').after(
				'<span class="error">Please enter first name</span>');

		valid = false;
	}

	if (lastName == "") {
		$('#lastName').after(
				'<span class="error">Please enter last name </span>');
		valid = false;
	}

	if (email == "") {
		$('#email').after('<span class="error">Please enter email</span>');

		valid = false;
	} else if (!emailFormat.test(email)) {
		$('#email').after(
				'<span class="error">Please Enter a valid email</span>');

		valid = false;
	}

	if (mobile == "") {
		$('#mobile').after(
				'<span class="error"> Please enter mobile number</span>');
		value = false;
	}

	/*
	 * else if (!mobileFormat.test(mobile)) { $('#mobile').after('<span
	 * class="error">Invalid Mobile Number</span>'); valid = false; }
	 */

	if (password == "") {
		$('#password')
				.after('<span class="error">Please enter password</span>');

		valid = false;
	} else if (password.length < 8) {
		$('#password')
				.after(
						'<span class="error">Password must be at least 8 characters long</span>');

		valid = false;
	}

	if (state == "") {
		$('#state').after('<span class="error">Please select state</span>');
		valid = false;
	}

	if (valid)
		return true;

	return false;
}
function isEmpty(object) {
	$(object).siblings(".error").remove();
	if (object.value == '') {
		$(object).after('<span class="error">Please enter value</span>');
	} else {
		$(object).siblings(".error").remove();
	}
}
function isValidEmail(object) {
	$(object).siblings(".error").remove();
	var emailFormat = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (object.value == '') {
		$(object).after('<span class="error">Please enter value</span>');
	} else if (!emailFormat.test(object.value)) {
		$(object).after('<span class="error">Please enter valid email</span>');
	}
}
function isValidPhone(object) {
	$(object).siblings(".error").remove();
	var mobileFormat = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	if (object.value == '') {
		$(object).after('<span class="error">Please enter value</span>');
	}/*
		 * else if(!mobileFormat.test(object.value)){ $(object).after('<span
		 * class="error">Please enter valid phone</span>'); }
		 */
}
function showPassword() {
	var x = document.getElementById("password");
	if (x.type === "password") {
		x.type = "text";
	} else {
		x.type = "password";
	}
}

function doRegister() {
	$("#errors").html("");
	$("#success").html("");
	if (validateform()) {
		// fetch all fields
		var firstName = $("#firstName").val();
		var lastName = $("#lastName").val();
		var mobile = $("#mobile").val();
		var email = $("#email").val();
		var password = $("#password").val();
		var state = $("#state").val();
		$.ajax({
			url : "http://localhost:8585/JOBBoardPortal/create-user",
			type : "POST",
			data : {
				firstName : firstName,
				lastName  : lastName,
				mobile :    mobile,
				email :     email,
				password  : password,
				state  :    state,
			},
			dataType : "json",
			success : function(data) {
				console.log(data);
				$("#success").html(data.email+" Successfully Completed");
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(jqXHR);
				if(jqXHR.status==400)
				$("#errors").html(jqXHR.responseJSON.message);
			}
		});
		return false;
	}
}