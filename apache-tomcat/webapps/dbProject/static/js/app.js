// Ran on website load
document.addEventListener('DOMContentLoaded', function() {
    // Your existing window.onload content
    loadData('hotelChain', 'hotelChain', item => ({ 
        text: item.hotelChainName, 
        value: item.chainId 
    }));

    // Event listeners
    document.getElementById('searchForm').addEventListener('submit', performSearch);
});

// Automatically performed on page load
function loadData(daoType, elementId, mapFunction) {
    fetch('./getData?daoType=' + daoType)
        .then(response => response.json())
        .then(data => populateDropdown(data, elementId, mapFunction))
        .catch(error => console.error('Error:', error));
}

// Used to populate dropdown with a map (e.x. hotelname -> hotelid), which is useful information to store in the dropdown, hidden
function populateDropdown(data, elementId, mapFunction) {
    const selectElement = document.getElementById(elementId);
    selectElement.innerHTML = ''; // Clear existing options
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
    event.preventDefault(); // Prevents traditional form submission
    var hotelChainId = document.getElementById('hotelChain').value;
    
    fetch('./getData?hotelChainId=' + hotelChainId)
    .then(response => response.json())
    .then(hotels => {
        var resultsSection = document.getElementById('searchResults');
        resultsSection.innerHTML = ''; // Clear previous results
        
        // Create and append elements for each hotel
        hotels.forEach(hotel => {
            let hotelCard = document.createElement('div');
            hotelCard.className = 'hotel-card';
            
            // Add hotel details here. Modify as per your Hotel model attributes
            hotelCard.innerHTML = `
                <div class="hotel-header">
                    <h3>${hotel.hotelName}</h3>
                </div>
                <div class="hotel-body">
                    <p>Star Rating: ${hotel.starRating}</p>
                    <p>Address: ${hotel.address}</p>
                    <p>Number of Rooms: ${hotel.nRooms}</p>
                    <p>Contact: ${hotel.contactEmails}, ${hotel.phoneNumber}</p>
                </div>`;

            resultsSection.appendChild(hotelCard);
        });
    })
    .catch((error) => {
        console.error('Error:', error);
    });
    
    return false; // Prevents traditional form submission
}

