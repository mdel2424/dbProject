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
    signUp();
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
        resultsSection.innerHTML = `<p>Number of results: ${rooms.length}</p>`;
        rooms.forEach(room => {
            let roomCard = document.createElement('div');
            roomCard.className = 'room-card';
            roomCard.innerHTML = `
                <div class="search-card">
                <div class="search-header">
                    <h3>Room Number: ${room.roomId}</h3>
                </div>
                <div class="search-body">
                    <p>Damages: ${room.location}</p>
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
                window.location.href = 'loginToBook.html?roomId=' + encodeURIComponent(roomId);
            });               
        });
    }
}

function signUp() {
    const signupForm = document.getElementById('signUpStuff');
    const errorDisplayElement = document.getElementById('errorDisplay'); // Add an element with this ID to your HTML

    if (signupForm) {
        signupForm.addEventListener('submit', function(event) {
            event.preventDefault();

            const fullName = document.getElementById('signupName').value;
            const ssn = document.getElementById('signupSSN').value;
            const email = document.getElementById('signupEmail').value;

            let queryStr = "ssn=" + encodeURIComponent(ssn) + "&fullName=" + encodeURIComponent(fullName) + "&email=" + encodeURIComponent(email);

            fetch('./createClient?' + queryStr)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json(); // Assuming your servlet responds with JSON
            })
            .then(data => {
                console.log('User created:', data);
                window.location.href = './createBooking?SSN=' + encodeURIComponent(ssn);
                window.location.href = 'index.html'; 
            })
            .catch(error => {
                console.log('Error:', error);
                if (errorDisplayElement) {
                    errorDisplayElement.textContent = 'Error creating user. Please try again.';
                }
            });

            return false;
        });
    }
}

function createBooking(startDate, endDate, roomId, clientId) {
    const queryStr = `startDate=${encodeURIComponent(startDate)}&endDate=${encodeURIComponent(endDate)}&roomId=${encodeURIComponent(roomId)}&clientId=${encodeURIComponent(clientId)}`;

    fetch('./createBooking?' + queryStr)
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to create booking');
        }
        return response.json(); // Assuming your servlet sends back a JSON response
    })
    .then(data => {
        console.log('Booking created:', data);
        alert('Booking successful!');
        window.location.href = 'index.html'; // Redirect to homepage or a confirmation page
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error creating booking. Please try again.');
    });
}