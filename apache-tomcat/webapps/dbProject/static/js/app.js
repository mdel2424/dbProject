function loadData(daoType, elementId, mapFunction) {
    fetch('./getData?daoType=' + daoType)
        .then(response => response.json())
        .then(data => populateDropdown(data, elementId, mapFunction))
        .catch(error => console.error('Error:', error));
}

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

document.addEventListener('DOMContentLoaded', function() {
    // Your existing window.onload content
    loadData('hotelChain', 'hotelChain', item => ({ 
        text: item.hotelChainName, 
        value: item.chainId 
    }));

    document.getElementById('searchForm').onsubmit = performSearch;
});

function performSearch() {
    var hotelChainId = document.getElementById('hotelChain').value;
    
    fetch('/getData?hotelChainId=' + hotelChainId)
    .then(response => response.json())
    .then(hotels => {
        var resultsSection = document.getElementById('searchResults');
        resultsSection.innerHTML = ''; // Clear previous results

        // Create and append elements for each hotel
        hotels.forEach(hotel => {
            let hotelDiv = document.createElement('div');
            hotelDiv.className = 'hotel';

            // Add hotel details here. Modify as per your Hotel model attributes
            hotelDiv.innerHTML = `<h3>${hotel.hotelName}</h3>
                                  <p>Star Rating: ${hotel.starRating}</p>
                                  <p>Address: ${hotel.address}</p>
                                  <p>Number of Rooms: ${hotel.nRooms}</p>
                                  <p>Contact: ${hotel.contactEmails}, ${hotel.phoneNumber}</p>`;

            resultsSection.appendChild(hotelDiv);
        });
    })
    .catch((error) => {
        console.error('Error:', error);
    });

    return false; // Prevents traditional form submission
}
