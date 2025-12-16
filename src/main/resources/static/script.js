function showMessage() {
  alert("Welcome aboard Timeout Airline! Navigate using the menu above.");
}
// Load all users
function loadUsers() {
  fetch('/api/users')
    .then(response => response.json())
    .then(users => {
      const tableBody = document.querySelector('#usersTable tbody');
      tableBody.innerHTML = '';
      users.forEach(user => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${user.idUser}</td>
          <td>${user.firstName}</td>
          <td>${user.lastName}</td>
          <td>${user.email}</td>
          <td>${user.phone}</td>
          <td>${user.birthDate}</td>
          <td>
            <button onclick="editUser(${user.idUser})">Edit</button>
            <button onclick="deleteUser(${user.idUser})">Delete</button>
          </td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => console.error('Error loading users:', error));
}

// Add or update user
document.getElementById('userForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const id = document.getElementById('userId').value;
  const user = {
    firstName: document.getElementById('firstName').value,
    lastName: document.getElementById('lastName').value,
    email: document.getElementById('email').value,
    phone: document.getElementById('phone').value,
    birthDate: document.getElementById('birthDate').value
  };

  const method = id ? 'PUT' : 'POST';
  const url = id ? `/api/users/${id}` : '/api/users';

  fetch(url, {
    method: method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(user)
  })
  .then(response => {
    if (!response.ok) throw new Error('Error saving user');
    return response.json();
  })
  .then(() => {
    loadUsers();
    document.getElementById('userForm').reset();
    document.getElementById('userId').value = '';
  })
  .catch(error => console.error('Error saving user:', error));
});

// Edit user (prefill form)
function editUser(id) {
  fetch(`/api/users/${id}`)
    .then(response => response.json())
    .then(user => {
      document.getElementById('userId').value = user.idUser;
      document.getElementById('firstName').value = user.firstName;
      document.getElementById('lastName').value = user.lastName;
      document.getElementById('email').value = user.email;
      document.getElementById('phone').value = user.phone;
      document.getElementById('birthDate').value = user.birthDate;
    })
    .catch(error => console.error('Error loading user:', error));
}

// Delete user
function deleteUser(id) {
  fetch(`/api/users/${id}`, { method: 'DELETE' })
    .then(() => loadUsers())
    .catch(error => console.error('Error deleting user:', error));
}

// Load all clients
function loadClients() {
  fetch('/api/clients')
    .then(response => response.json())
    .then(clients => {
      const tableBody = document.querySelector('#clientsTable tbody');
      tableBody.innerHTML = '';
      clients.forEach(client => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${client.numPassport}</td>
          <td>${client.user ? client.user.idUser : ''}</td>
          <td>${client.user ? client.user.firstName : ''}</td>
          <td>${client.user ? client.user.lastName : ''}</td>
          <td>${client.user ? client.user.email : ''}</td>
          <td>
            <button onclick="editClient('${client.numPassport}')">Edit</button>
            <button onclick="deleteClient('${client.numPassport}')">Delete</button>
          </td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => console.error('Error loading clients:', error));
}


// Add or update client
document.getElementById('clientForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const passportHidden = document.getElementById('clientPassportHidden').value;
  const client = {
    numPassport: document.getElementById('numPassport').value,
    user: { idUser: document.getElementById('userId').value }
  };

  const method = passportHidden ? 'PUT' : 'POST';
  const url = passportHidden ? `/api/clients/${passportHidden}` : '/api/clients';

  fetch(url, {
    method: method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(client)
  })
  .then(response => {
    if (!response.ok) throw new Error('Error saving client');
    return response.json();
  })
  .then(() => {
    loadClients();
    document.getElementById('clientForm').reset();
    document.getElementById('clientPassportHidden').value = '';
  })
  .catch(error => console.error('Error saving client:', error));
});

// Edit client (prefill form)
function editClient(passport) {
  fetch(`/api/clients/${passport}`)
    .then(response => response.json())
    .then(client => {
      document.getElementById('clientPassportHidden').value = client.numPassport;
      document.getElementById('numPassport').value = client.numPassport;
      document.getElementById('userId').value = client.user ? client.user.idUser : '';
    })
    .catch(error => console.error('Error loading client:', error));
}


// Delete client
function deleteClient(passport) {
  fetch(`/api/clients/${passport}`, { method: 'DELETE' })
    .then(() => loadClients())
    .catch(error => console.error('Error deleting client:', error));
}

// Load all employees
function loadEmployees() {
  fetch('/api/employees')
    .then(response => response.json())
    .then(employees => {
      const tableBody = document.querySelector('#employeesTable tbody');
      tableBody.innerHTML = '';
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
          <td>
            <button onclick="editEmployee(${emp.numEmp})">Edit</button>
            <button onclick="deleteEmployee(${emp.numEmp})">Delete</button>
          </td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => console.error('Error loading employees:', error));
}

// Add or update employee
document.getElementById('employeeForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const empHidden = document.getElementById('employeeIdHidden').value;

  const employee = {
    numEmp: parseInt(document.getElementById('numEmp').value, 10),
    profession: document.getElementById('profession').value,
    title: document.getElementById('title').value,
    user: { idUser: parseInt(document.getElementById('userId').value, 10) }
  };

  const method = empHidden ? 'PUT' : 'POST';
  const url = empHidden ? `/api/employees/${empHidden}` : '/api/employees';

  fetch(url, {
    method: method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(employee)
  })
  .then(response => {
    if (!response.ok) throw new Error('Error saving employee');
    return response.json();
  })
  .then(() => {
    loadEmployees();
    document.getElementById('employeeForm').reset();
    document.getElementById('employeeIdHidden').value = '';
  })
  .catch(error => console.error('Error saving employee:', error));
});

// Edit employee (prefill form)
function editEmployee(empId) {
  fetch(`/api/employees/${empId}`)
    .then(response => response.json())
    .then(emp => {
      document.getElementById('employeeIdHidden').value = emp.numEmp;
      document.getElementById('numEmp').value = emp.numEmp;
      document.getElementById('profession').value = emp.profession;
      document.getElementById('title').value = emp.title;
      document.getElementById('userId').value = emp.user ? emp.user.idUser : '';
    })
    .catch(error => console.error('Error loading employee:', error));
}

// Delete employee
function deleteEmployee(empId) {
  fetch(`/api/employees/${empId}`, { method: 'DELETE' })
    .then(() => loadEmployees())
    .catch(error => console.error('Error deleting employee:', error));
}


// Load all planes
function loadPlanes() {
  fetch('/api/planes')
    .then(response => response.json())
    .then(planes => {
      const tableBody = document.querySelector('#planesTable tbody');
      tableBody.innerHTML = '';
      planes.forEach(plane => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${plane.idPlane}</td>
          <td>${plane.brand}</td>
          <td>${plane.model}</td>
          <td>${plane.manufacturingYear}</td>
          <td>
            <button onclick="editPlane(${plane.idPlane})">Edit</button>
            <button onclick="deletePlane(${plane.idPlane})">Delete</button>
          </td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => console.error('Error loading planes:', error));
}

// Add or update plane
document.getElementById('planeForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const id = document.getElementById('planeIdHidden').value;
  const plane = {
    brand: document.getElementById('brand').value,
    model: document.getElementById('model').value,
    manufacturingYear: document.getElementById('manufacturingYear').value
  };

  const method = id ? 'PUT' : 'POST';
  const url = id ? `/api/planes/${id}` : '/api/planes';

  fetch(url, {
    method: method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(plane)
  })
  .then(response => {
    if (!response.ok) throw new Error('Error saving plane');
    return response.json();
  })
  .then(() => {
    loadPlanes();
    document.getElementById('planeForm').reset();
    document.getElementById('planeIdHidden').value = '';
  })
  .catch(error => console.error('Error saving plane:', error));
});

// Edit plane (prefill form)
function editPlane(id) {
  fetch(`/api/planes/${id}`)
    .then(response => response.json())
    .then(plane => {
      document.getElementById('planeIdHidden').value = plane.idPlane;
      document.getElementById('brand').value = plane.brand;
      document.getElementById('model').value = plane.model;
      document.getElementById('manufacturingYear').value = plane.manufacturingYear;
    })
    .catch(error => console.error('Error loading plane:', error));
}

// Delete plane
function deletePlane(id) {
  fetch(`/api/planes/${id}`, { method: 'DELETE' })
    .then(() => loadPlanes())
    .catch(error => console.error('Error deleting plane:', error));
}

// Load all airports
function loadAirports() {
  fetch('/api/airports')
    .then(response => response.json())
    .then(airports => {
      const tableBody = document.querySelector('#airportsTable tbody');
      tableBody.innerHTML = '';
      airports.forEach(airport => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${airport.idAirport}</td>
          <td>${airport.nameAirport}</td>
          <td>${airport.cityAirport}</td>
          <td>${airport.countryAirport}</td>
          <td>
            <button onclick="editAirport(${airport.idAirport})">Edit</button>
            <button onclick="deleteAirport(${airport.idAirport})">Delete</button>
          </td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => console.error('Error loading airports:', error));
}

// Add or update airport
document.getElementById('airportForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const id = document.getElementById('airportIdHidden').value;
  const airport = {
    nameAirport: document.getElementById('nameAirport').value,
    cityAirport: document.getElementById('cityAirport').value,
    countryAirport: document.getElementById('countryAirport').value
  };

  const method = id ? 'PUT' : 'POST';
  const url = id ? `/api/airports/${id}` : '/api/airports';

  fetch(url, {
    method: method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(airport)
  })
  .then(response => {
    if (!response.ok) throw new Error('Error saving airport');
    return response.json();
  })
  .then(() => {
    loadAirports();
    document.getElementById('airportForm').reset();
    document.getElementById('airportIdHidden').value = '';
  })
  .catch(error => console.error('Error saving airport:', error));
});

// Edit airport (prefill form)
function editAirport(id) {
  fetch(`/api/airports/${id}`)
    .then(response => response.json())
    .then(airport => {
      document.getElementById('airportIdHidden').value = airport.idAirport;
      document.getElementById('nameAirport').value = airport.nameAirport;
      document.getElementById('cityAirport').value = airport.cityAirport;
      document.getElementById('countryAirport').value = airport.countryAirport;
    })
    .catch(error => console.error('Error loading airport:', error));
}

// Delete airport
function deleteAirport(id) {
  fetch(`/api/airports/${id}`, { method: 'DELETE' })
    .then(() => loadAirports())
    .catch(error => console.error('Error deleting airport:', error));
}


// Load all flights
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
          <td>
            <button onclick="editFlight('${flight.flightNumber}')">Edit</button>
            <button onclick="deleteFlight('${flight.flightNumber}')">Delete</button>
          </td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => console.error('Error loading flights:', error));
}

// Add or update flight
document.getElementById('flightForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const flightHidden = document.getElementById('flightIdHidden').value;
  const flight = {
    flightNumber: document.getElementById('flightNumber').value,
    departureCity: document.getElementById('departureCity').value,
    arrivalCity: document.getElementById('arrivalCity').value,
    departureHour: document.getElementById('departureHour').value,
    arrivalHour: document.getElementById('arrivalHour').value,
    numberOfSeat: document.getElementById('numberOfSeat').value,
    economyClassPrice: document.getElementById('economyClassPrice').value
  };

  const method = flightHidden ? 'PUT' : 'POST';
  const url = flightHidden ? `/api/flights/${flightHidden}` : '/api/flights';

  fetch(url, {
    method: method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(flight)
  })
  .then(response => {
    if (!response.ok) throw new Error('Error saving flight');
    return response.json();
  })
  .then(() => {
    loadFlights();
    document.getElementById('flightForm').reset();
    document.getElementById('flightIdHidden').value = '';
  })
  .catch(error => console.error('Error saving flight:', error));
});

// Edit flight (prefill form)
function editFlight(flightNumber) {
  fetch(`/api/flights/${flightNumber}`)
    .then(response => response.json())
    .then(flight => {
      document.getElementById('flightIdHidden').value = flight.flightNumber;
      document.getElementById('flightNumber').value = flight.flightNumber;
      document.getElementById('departureCity').value = flight.departureCity;
      document.getElementById('arrivalCity').value = flight.arrivalCity;
      document.getElementById('departureHour').value = flight.departureHour;
      document.getElementById('arrivalHour').value = flight.arrivalHour;
      document.getElementById('numberOfSeat').value = flight.numberOfSeat;
      document.getElementById('economyClassPrice').value = flight.economyClassPrice;
    })
    .catch(error => console.error('Error loading flight:', error));
}

// Delete flight
function deleteFlight(flightNumber) {
  fetch(`/api/flights/${flightNumber}`, { method: 'DELETE' })
    .then(() => loadFlights())
    .catch(error => console.error('Error deleting flight:', error));
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
// Load all bookings
function loadBookings() {
  fetch('/api/bookings')
    .then(response => response.json())
    .then(bookings => {
      const tableBody = document.querySelector('#bookingsTable tbody');
      tableBody.innerHTML = '';
      bookings.forEach(book => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${book.idReservation}</td>
          <td>${book.typeOfSeat}</td>
          <td>${book.client ? book.client.numPassport : ''}</td>
          <td>${book.flight ? book.flight.flightNumber : ''}</td>
          <td>
            <button onclick="editBooking(${book.idReservation})">Edit</button>
            <button onclick="deleteBooking(${book.idReservation})">Delete</button>
          </td>
        `;
        tableBody.appendChild(row);
      });
    })
    .catch(error => console.error('Error loading bookings:', error));
}

// Add or update booking
document.getElementById('bookingForm').addEventListener('submit', function(event) {
  event.preventDefault();

  const id = document.getElementById('bookingIdHidden').value;
  const booking = {
    client: { numPassport: document.getElementById('clientPassport').value },
    flight: { flightNumber: document.getElementById('flightNumber').value },
    typeOfSeat: document.getElementById('typeOfSeat').value
  };

  const method = id ? 'PUT' : 'POST';
  const url = id ? `/api/bookings/${id}` : '/api/bookings';

  fetch(url, {
    method: method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(booking)
  })
  .then(response => {
    if (!response.ok) throw new Error('Error saving booking');
    return response.json();
  })
  .then(() => {
    loadBookings();
    document.getElementById('bookingForm').reset();
    document.getElementById('bookingIdHidden').value = '';
  })
  .catch(error => console.error('Error saving booking:', error));
});

// Edit booking (prefill form)
function editBooking(id) {
  fetch(`/api/bookings/${id}`)
    .then(response => response.json())
    .then(book => {
      document.getElementById('bookingIdHidden').value = book.idReservation;
      document.getElementById('clientPassport').value = book.client ? book.client.numPassport : '';
      document.getElementById('flightNumber').value = book.flight ? book.flight.flightNumber : '';
      document.getElementById('typeOfSeat').value = book.typeOfSeat;
    })
    .catch(error => console.error('Error loading booking:', error));
}

// Delete booking
function deleteBooking(id) {
  fetch(`/api/bookings/${id}`, { method: 'DELETE' })
    .then(() => loadBookings())
    .catch(error => console.error('Error deleting booking:', error));
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
