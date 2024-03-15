function loadData(daoType, elementId, mapFunction) {
    fetch('./getData?daoType=' + daoType)
        .then(response => response.json())
        .then(data => populateDropdown(data, elementId, mapFunction))
        .catch(error => console.error('Error:', error));
}

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

window.onload = function() {
    loadData('hotelChain', 'hotelChain', item => ({ 
        text: item.hotelChainName, 
        value: item.chainId 
    }));
};