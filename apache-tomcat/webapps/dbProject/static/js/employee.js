document.addEventListener('DOMContentLoaded', function() {
    // Add event listener to the search form
    const searchForm = document.getElementById('bookingSearch');
    if (searchForm) {
        searchForm.addEventListener('submit', performSearch);
    }
});


// Handle search form submission
function performSearch(event) {
    event.preventDefault();
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
function displaySearchResults(rooms) {
    var resultsSection = document.getElementById('bookingSearch');
    resultsSection.innerHTML = '';

    if (rooms.length === 0 || rooms === '') {
        resultsSection.innerHTML = '<p>No results. Try again.</p>';
    } else {
        rooms.forEach(room => {
            let bookingCard = document.createElement('div');
            bookingCard.className = 'room-card';
            bookingCard.innerHTML = `
                <div class="search-card">
                <div class="search-header">
                    <h3>Room Number: ${booking.bookingId}</h3>
                </div>
                <div class="search-body">
                    <p>Name: ${booking.name}</p>
                    <p>Date: ${booking.date}</p>
                    <button class="convertToBooking" data-room-id="${booking.bookingId}"> Convert to booking </button>
                </div>
                </div>`;

            resultsSection.appendChild(bookingCard);

            bookingCard.querySelector('.bookRoomButton').addEventListener('click', function() {
                let roomId = this.getAttribute('data-room-id');
                window.location.href = 'CLogin.html?roomId=' + encodeURIComponent(roomId);
            });               
        });
    }
}

// Unknown
var modal = document.getElementById("adminModal");
var btn = document.getElementById("adminBtn");
var span = document.getElementsByClassName("close")[0];
var form = document.getElementById("adminIdForm");
var adminIdInput = document.getElementById("adminId");

// Function to reset admin ID input
function resetAdminIdInput() {
    adminIdInput.value = '';
}

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
    resetAdminIdInput(); // Reset the input field
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
        resetAdminIdInput(); // Reset the input field
    }
}

// Handle form submission
form.addEventListener('submit', function(event) {
    resetAdminIdInput(); // Reset the input field
    window.location.href = 'admin.html'; // Redirect to the admin page
});
