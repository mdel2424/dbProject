document.addEventListener('DOMContentLoaded', function() {
    // Initialize modal for Admin access
    initializeAdminModal();

    document.getElementById('customerBtn').addEventListener('click', function() {
        window.location.href = 'index.html'; // Redirects to the index.html page
    });
    

    // Add event listener to the search form
    const searchForm = document.getElementById('bookingSearch');
    if (searchForm) {
        searchForm.addEventListener('submit', performSearch);
    }

        // Add event listener to the search form
    document.body.addEventListener('click', function(event) {
        if (event.target && event.target.classList.contains('convertToBooking')) {
            const bookingId = event.target.getAttribute('data-booking-id'); // Get the booking ID from the clicked button
            convertToBooking(bookingId); // Call the function to convert to booking
        }
    });
});

function convertToBooking(bookingId) {
    let queryStr = "bookingId=" + encodeURIComponent(bookingId);
    fetch('./convertBooking?' + queryStr)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Process the response
    })
    .then(data => {
        console.log('Success:', data);
        performSearch(); // Refresh the search results after successful booking conversion
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}



// Initialize modal functionality for Admin access
function initializeAdminModal() {
    var modal = document.getElementById("adminModal");
    var btn = document.getElementById("adminBtn");
    var span = document.getElementsByClassName("close")[0];
    var adminIdInput = document.getElementById("adminId");

    // When the Admin button is clicked, display the modal
    if (btn) {
        btn.onclick = function() {
            modal.style.display = "block";
        };
    }

    // When the close button (x) in the modal is clicked, hide the modal
    if (span) {
        span.onclick = function() {
            modal.style.display = "none";
            adminIdInput.value = ''; // Reset the admin ID input
        };
    }

    // Also hide the modal if the user clicks outside of it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
            adminIdInput.value = ''; // Reset the admin ID input
        }
    };

    // Handle the admin ID form submission within the modal
    var form = document.getElementById('adminIdForm').addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the form from actually submitting
        var adminIdInput = document.getElementById("adminId");
        
        // Check if the entered Admin ID is "1"
        if (adminIdInput.value === "1") {
            // Correct Admin ID entered, redirect to the admin page
            window.location.href = 'unknown/admin.html';
        } else {
            // Incorrect Admin ID entered, show an error message
            alert("User is not an admin");
            adminIdInput.value = ''; // Optionally reset the input field
        }
    });
}

// Handle search form submission
function performSearch(event) {
    if (event) event.preventDefault(); // Prevent the default action only if called as an event handler
    let queryString = '';
    let formElements = document.getElementById('bookingSearch').elements;

    for (let element of formElements) {
        if (element.name && element.value) {
            queryString += queryString.length > 0 ? '&' : '';
            queryString += encodeURIComponent(element.name) + '=' + encodeURIComponent(element.value);
        }
    }

    fetch('./getBooking?' + queryString)
        .then(response => response.json())
        .then(displaySearchResults)
        .catch(error => console.error('Error:', error));
}


// Display search results
function displaySearchResults(bookings) {
    var resultsSection = document.getElementById('searchResults');
    resultsSection.innerHTML = '';

    if (!bookings.length) {
        resultsSection.innerHTML = '<p>No results. Try again.</p>';
    } else {
        bookings.forEach(booking => {
            let bookingCard = document.createElement('div');
            bookingCard.className = 'room-card';
            // Conditionally rendering the 'Convert to booking' button only if booking status is 'reserved'
            let buttonHTML = booking.status.toLowerCase() === 'reserved' ? `<button class="convertToBooking" data-booking-id="${booking.bookingId}"> Convert to booking </button>` : '';
            bookingCard.innerHTML = `
                <div class="search-card">
                    <div class="search-header">
                        <h3>Booking ID: ${booking.bookingId}</h3>
                        <h4>Status: ${booking.status}</h4>
                    </div>
                    <div class="search-body">
                        <p>Name: ${booking.clientName}</p>
                        <p>Room Number: ${booking.roomNumber}</p>
                        <p>Start Date: ${booking.startDate}</p>
                        <p>End Date: ${booking.endDate}</p>
                        ${buttonHTML}
                    </div>
                </div>`;
        
            resultsSection.appendChild(bookingCard);
        });
    }
}
