// Ran on website load
document.addEventListener('DOMContentLoaded', function() {
    loadData('hotelChain', item => ({ 
        text: item.hotelChainName, 
        value: item.chainId 
    }));
    // Event listeners
    document.getElementById('searchForm').addEventListener('submit', performSearch);
});

// Automatically performed on page load
function loadData(elementId, mapFunction) {
    fetch('./populateData')
        .then(response => response.json())
        .then(data => populateDropdown(data, elementId, mapFunction))
        .catch(error => console.error('Error:', error));
}

// Used to populate dropdown with a map (e.x. hotelname -> hotelid), which is useful information to store in the dropdown, hidden
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

// Performed when search button is clicked, for now just used for getting all hotels under a hotel chain
function performSearch(event) {
    event.preventDefault();
    let formElements = document.getElementById('searchForm').elements;
    let queryString = '';

    for (let element of formElements) {
        if (element.name && element.value) {
            if (queryString !== '') {
                queryString += '&';
            }
            queryString += encodeURIComponent(element.name) + '=' + encodeURIComponent(element.value);
        }
    }

    fetch('./getRoom?' + queryString)
    .then(response => response.json())
    .then(rooms => {
        var resultsSection = document.getElementById('searchResults');
        resultsSection.innerHTML = '';
        
        if (rooms.length === 0 || rooms === '') { // Checking if the response is empty
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
                    <button class = "bookRoomButton" data-room-id="${room.roomId}"> Book Room </button>
                    </div>
                    </div>`;




                resultsSection.appendChild(roomCard);

                // Add event listener to the dynamically created button
                roomCard.querySelector('.bookRoomButton').addEventListener('click', function() {
                    // Extract roomId from the button's data-room-id attribute
                    let roomId = this.getAttribute('data-room-id');
                    // Redirect to booking.html with roomId as a parameter
                    window.location.href = 'CLogin.html?roomId=' + encodeURIComponent(roomId);
                });               
            });
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    });

    return false;
}

