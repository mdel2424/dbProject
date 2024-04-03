document.addEventListener('DOMContentLoaded', function() {

    // Initialize payment form event listener for redirecting to confirmation.html
    initializePaymentFormRedirection();
});

//this will redirect users to payment once they sign up
//it will create an instance of client since it is a new client
function initializePaymentFormRedirection() {
    const signupForm = document.getElementById('signUpStuff');
    if (signupForm) {
        signupForm.addEventListener('submit', function(event) {
            event.preventDefault();

            const name = document.getElementById('signupName').value;
            const SSN = document.getElementById('signupSSN').value;
            const email = document.getElementById('signupEmail').value;

            //encodes SQL query
            let queryStr = encodeURIComponent("name="+name+"&SSN="+SSN+"&email="+email)

            //creates sql user
            fetch('./createClient' + queryStr)
            .then(response => response.json())
            .then(data => {
                
                console.log('User created:', data);
        
                //window.location.href = 'payment.html?SSN=';

        }) //logs that a user was createds
            .catch(error => console.log('Error:', error)) //just logs error (if any)

            return false;

        });
    }
}