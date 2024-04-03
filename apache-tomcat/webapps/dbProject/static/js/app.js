document.addEventListener('DOMContentLoaded', function() {
    // Load hotel chain data into dropdown
    loadData('hotelChain', item => ({ 
        text: item.hotelChainName, 
        value: item.chainId 
    }));

    // Add event listener to the search form
    const searchForm = document.getElementById('searchForm');
    if (searchForm) {
        searchForm.addEventListener('submit', performSearch);
    }

    // Initialize login form event listener for redirecting to payment.html
    initializeLoginFormRedirection();

    // Initialize payment form event listener for redirecting to confirmation.html
    initializePaymentFormRedirection();
});

// Load data for dropdown
function loadData(elementId, mapFunction) {
    fetch('./populateData')
        .then(response => response.json())
        .then(data => populateDropdown(data, elementId, mapFunction))
        .catch(error => console.error('Error:', error));
}

// Populate dropdown with fetched data
function populateDropdown(data, elementId, mapFunction) {
    const selectElement = document.getElementById(elementId);
    data.forEach(item => {
        let option = document.createElement('option');
        let optionData = mapFunction(item);
        option.value = optionData.value;
        option.textContent = optionData.text;
        selectElement.appendChild(option);
    });
}

// Handle search form submission
function performSearch(event) {
    event.preventDefault();
    let queryString = '';
    let formElements = document.getElementById('searchForm').elements;

    for (let element of formElements) {
        if (element.name && element.value) {
            queryString += queryString.length > 0 ? '&' : '';
            queryString += encodeURIComponent(element.name) + '=' + encodeURIComponent(element.value);
        }
    }

    fetch('./getRoom?' + queryString)
        .then(response => response.json())
        .then(displaySearchResults)
        .catch(error => console.error('Error:', error));
}

// Display search results
function displaySearchResults(rooms) {
    var resultsSection = document.getElementById('searchResults');
    resultsSection.innerHTML = '';

    if (rooms.length === 0 || rooms === '') {
        resultsSection.innerHTML = '<p>No results. Try again.</p>';
    } else {
        rooms.forEach(room => {
            let roomCard = document.createElement('div');
            roomCard.className = 'room-card';
            roomCard.innerHTML = `
                <div class="search-card">
                <div class="search-header">
                    <h3>Room Number: ${room.roomId}</h3>
                </div>
                <div class="search-body">
                    <p>Damages: ${room.damages}</p>
                    <p>View: ${room.view}</p>
                    <p>Price: ${room.price}</p>
                    <p>Capacity: ${room.capacity}</p>
                    <p>Extendable: ${room.extendable ? 'Yes' : 'No'}</p>
                    <p>Amenities: ${room.amenities}</p>
                    <p>HotelID: ${room.hotelId}</p>
                    <button class="bookRoomButton" data-room-id="${room.roomId}"> Book Room </button>
                </div>
                </div>`;

            resultsSection.appendChild(roomCard);

            roomCard.querySelector('.bookRoomButton').addEventListener('click', function() {
                let roomId = this.getAttribute('data-room-id');
                window.location.href = 'CLogin.html?roomId=' + encodeURIComponent(roomId);
            });               
        });
    }
}

// Initialize login form redirection
function initializeLoginFormRedirection() {
    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault();
            window.location.href = 'payment.html';
        });
    }
}

// Initialize payment form redirection to confirmation.html
function initializePaymentFormRedirection() {
    const paymentForm = document.getElementById('paymentForm');
    if (paymentForm) {
        paymentForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the form from actually submitting
            window.location.href = 'confirmation.html'; // Redirect to confirmation.html
        });
    }
}
