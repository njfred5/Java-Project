function showMessage() {
  alert("Welcome aboard Timeout Airline! Navigate using the menu above.");
}
// Fetch and display users
function loadUsers() {
  fetch('/api/users')
    .then(response => response.json())
    .then(users => {
      const tableBody = document.querySelector('#usersTable tbody');
      tableBody.innerHTML = ''; // clear old rows
      users.forEach(user => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${user.idUser}</td>
          <td>${user.firstName}</td>
          <td>${user.lastName}</td>
          <td>${user.email}</td>
          <td>${user.phone}</td>
          <td>${user.birthDate}</td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => {
      console.error('Error loading users:', error);
    });
}
// Fetch and display clients
function loadClients() {
  fetch('/api/clients')
    .then(response => response.json())
    .then(clients => {
      const tableBody = document.querySelector('#clientsTable tbody');
      tableBody.innerHTML = ''; // clear old rows
      clients.forEach(client => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${client.numPassport}</td>
          <td>${client.user ? client.user.idUser : ''}</td>
          <td>${client.user ? client.user.firstName : ''}</td>
          <td>${client.user ? client.user.lastName : ''}</td>
          <td>${client.user ? client.user.email : ''}</td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => {
      console.error('Error loading clients:', error);
    });
}
// Fetch and display employees
function loadEmployees() {
  fetch('/api/employees')
    .then(response => response.json())
    .then(employees => {
      const tableBody = document.querySelector('#employeesTable tbody');
      tableBody.innerHTML = ''; // clear old rows
      employees.forEach(emp => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${emp.numEmp}</td>
          <td>${emp.profession}</td>
          <td>${emp.title}</td>
          <td>${emp.user ? emp.user.idUser : ''}</td>
          <td>${emp.user ? emp.user.firstName : ''}</td>
          <td>${emp.user ? emp.user.lastName : ''}</td>
          <td>${emp.user ? emp.user.email : ''}</td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => {
      console.error('Error loading employees:', error);
    });
}
// Fetch and display planes
function loadPlanes() {
  fetch('/api/planes')
    .then(response => response.json())
    .then(planes => {
      const tableBody = document.querySelector('#planesTable tbody');
      tableBody.innerHTML = ''; // clear old rows
      planes.forEach(plane => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${plane.idPlane}</td>
          <td>${plane.brand}</td>
          <td>${plane.model}</td>
          <td>${plane.manufacturingYear}</td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => {
      console.error('Error loading planes:', error);
    });
}
// Fetch and display airports
function loadAirports() {
  fetch('/api/airports')
    .then(response => response.json())
    .then(airports => {
      const tableBody = document.querySelector('#airportsTable tbody');
      tableBody.innerHTML = ''; // clear old rows
      airports.forEach(airport => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${airport.idAirport}</td>
          <td>${airport.nameAirport}</td>
          <td>${airport.cityAirport}</td>
          <td>${airport.countryAirport}</td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => {
      console.error('Error loading airports:', error);
    });
}

// Fetch and display all flights
function loadFlights() {
  fetch('/api/flights')
    .then(response => response.json())
    .then(flights => {
      const tableBody = document.querySelector('#flightsTable tbody');
      tableBody.innerHTML = '';
      flights.forEach(flight => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${flight.flightNumber}</td>
          <td>${flight.departureCity}</td>
          <td>${flight.arrivalCity}</td>
          <td>${flight.departureHour}</td>
          <td>${flight.arrivalHour}</td>
          <td>${flight.numberOfSeat}</td>
          <td>${flight.economyClassPrice}</td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => console.error('Error loading flights:', error));
}
// Search flights by city/date
function searchFlights(departureCity, arrivalCity, departureHour) {
  const url = `/api/flights/search?departureCity=${departureCity}&arrivalCity=${arrivalCity}&departureHour=${departureHour}`;
  fetch(url)
    .then(response => response.json())
    .then(flights => {
      const tableBody = document.querySelector('#flightsTable tbody');
      tableBody.innerHTML = '';
      flights.forEach(flight => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${flight.flightNumber}</td>
          <td>${flight.departureCity}</td>
          <td>${flight.arrivalCity}</td>
          <td>${flight.departureHour}</td>
          <td>${flight.arrivalHour}</td>
          <td>${flight.numberOfSeat}</td>
          <td>${flight.economyClassPrice}</td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => console.error('Error searching flights:', error));
}
// Fetch and display bookings
function loadBookings() {
  fetch('/api/bookings')
    .then(response => response.json())
    .then(bookings => {
      const tableBody = document.querySelector('#bookingsTable tbody');
      tableBody.innerHTML = ''; // clear old rows
      bookings.forEach(book => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${book.idReservation}</td>
          <td>${book.typeOfSeat}</td>
          <td>${book.client ? book.client.numPassport : ''}</td>
          <td>${book.flight ? book.flight.flightNumber : ''}</td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => {
      console.error('Error loading bookings:', error);
    });
}
// Fetch and display reward info for a client
function checkReward(passportNumber) {
  const url = `/api/rewards/client/${passportNumber}/discount`;
  fetch(url)
    .then(response => response.text()) // reward endpoint returns plain text
    .then(message => {
      const resultDiv = document.getElementById('rewardResult');
      resultDiv.innerHTML = message;
    })
    .catch(error => {
      console.error('Error checking rewards:', error);
      document.getElementById('rewardResult').innerHTML = 'Error fetching reward information.';
    });
}
