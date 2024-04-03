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

            const fullName = document.getElementById('signupName').value;
            const ssn = document.getElementById('signupSSN').value;
            const address = document.getElementById('signupEmail').value;

            //encodes SQL query
            let queryStr = "ssn=" + encodeURIComponent(ssn) + "&fullName=" + encodeURIComponent(fullName) + "&address=" + encodeURIComponent(address);

            //creates sql user
            fetch('./createClient?' + queryStr)
            .then(data => {
                
                console.log('User created:', data);
        
                //window.location.href = 'payment.html?SSN=';

        }) //logs that a user was createds
            .catch(error => console.log('Error:', error)) //just logs error (if any)

            return false;

        });
    }
}