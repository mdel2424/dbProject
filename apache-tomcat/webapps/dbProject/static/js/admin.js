document.addEventListener('DOMContentLoaded', function() {

    initializeCreateChain();
    initializeCreateHotel();

});

function initializeCreateChain() {
    const addNewChain = document.getElementById('addNewChain');
    if (addNewChain) {
        addNewChain.addEventListener('submit', function(event) {
            event.preventDefault();

            const id = document.getElementById('chainId').value;
            const name  = document.getElementById('chainName').value;
            const locationHQ = document.getElementById('chainLocation').value;
            const numHotels = document.getElementById('chainHotels').value;
            const email = document.getElementById('chainContactEmail').value;
            const phoneNum = document.getElementById('chainContactPhone').value;


            //encodes SQL query
            let queryStr = "id=" + encodeURIComponent(id) 
            + "&name=" + encodeURIComponent(name) 
            + "&locationHQ=" + encodeURIComponent(locationHQ) 
            + "&numHotels=" + encodeURIComponent(numHotels)
            + "&email=" + encodeURIComponent(email)
            + "&phoneNum=" + encodeURIComponent(phoneNum);

            //creates sql user
            fetch('./createChain?' + queryStr)
            .then(data => {
                
                console.log('Chain created:', data);
        
                //window.location.href = 'payment.html?SSN=';

        }) //logs that a user was createds
            .catch(error => console.log('Error:', error)) //just logs error (if any)

            return false;

        });
    }
}

function initializeCreateHotel() {
    const addNewChain = document.getElementById('addNewHotel');
    if (addNewChain) {
        addNewChain.addEventListener('submit', function(event) {
            event.preventDefault();

            const hotelName = document.getElementById('hotelName').value;
            const hotelChainId  = document.getElementById('hotelChainId').value;
            const hotelId = document.getElementById('hotelId').value;
            const hotelAddress = document.getElementById('hotelAddress').value;
            const hotelNumberRooms = document.getElementById('hotelNumberRooms').value;
            const hotelContactEmail = document.getElementById('hotelContactEmail').value;
            const hotelContactPhone = document.getElementById('hotelContactPhone').value;


            //encodes SQL query
            let queryStr = "hotelName=" + encodeURIComponent(hotelName) 
            + "&hotelChainId=" + encodeURIComponent(hotelChainId) 
            + "&hotelId=" + encodeURIComponent(hotelId) 
            + "&hotelAddress=" + encodeURIComponent(hotelAddress)
            + "&hotelNumberRooms=" + encodeURIComponent(hotelNumberRooms)
            + "&hotelContactEmail=" + encodeURIComponent(hotelContactEmail)
            + "&hotelContactPhone=" + encodeURIComponent(hotelContactPhone);

            //creates sql user
            fetch('./createHotel?' + queryStr)
            .then(data => {
                
                console.log('Hotel created:', data);
        
                //window.location.href = 'payment.html?SSN=';

        }) //logs that a user was createds
            .catch(error => console.log('Error:', error)) //just logs error (if any)

            return false;

        });
    }
}

