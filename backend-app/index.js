const express = require('express')
const app = express()
const port = 3000

const USERS = [];
app.use(express.json());

const QUESTIONS = [];


app.get('/signup', function(req, res) {
  // Render the signup form HTML
  res.send(`
    <form action="/signup" method="post">
      <input type="email" name="email" placeholder="Email" required>
      <input type="password" name="password" placeholder="Password" required>
      <button type="submit">Sign Up</button>
    </form>
  `);
});
app.post('/signup', function(req, res) {
  const { email, password } = req.body;

  // Check if user with given email already exists
  const userExists = USERS.some(user => user.email === email);
  if (userExists) {
    return res.status(400).send('/login');
  }

  // Create a new user object
  const newUser = {
    email,
    password
  };

  // Add the new user to the USERS array
  USERS.push(newUser);

  // Return a success response
  res.status(200).send('User created successfully');
});

app.get('/login', function(req, res) {
    // Render the login form HTML
    res.send(`
      <form action="/login" method="post">
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Log In</button>
      </form>
    `);
  });

app.post('/login', function(req, res) {
  const { email, password } = req.body;

  // Find the user with the given email in the USERS array
  const user = USERS.find(user => user.email === email);

  // Check if user exists and if the password is correct
  if (!user || user.password !== password) {
    return res.status(401).send('Invalid email or password');
  }

  // Generate a random token (for simplicity, using a fixed string here)
  const token = 'RANDOM_TOKEN';

  // Return a success response with the token
  if (user && user.password === password) {
    return res.status(200).json({ token });}
});
  

app.get('/questions', function(req, res) {

  //return the user all the questions in the QUESTIONS array
  res.send("Hello World from route 3!")
})

app.get("/submissions", function(req, res) {
   // return the users submissions for this problem
  res.send("Hello World from route 4!")
});

// leaving as hard todos
// Create a route that lets an admin add a new problem
// ensure that only admins can do that.

// Middleware to check if the user is an admin
function isAdmin(req, res, next) {
  // Assuming you have some logic to determine if the user is an admin
  const isAdmin = true; // Change this with your actual admin check logic

  if (isAdmin) {
    // User is an admin, allow them to proceed
    next();
  } else {
    // User is not an admin, return a 401 unauthorized status code
    res.status(401).send('Unauthorized');
  }
}

// POST endpoint for adding a new problem (only accessible to admins)
app.post('/problems', isAdmin, function(req, res) {
  // Check if the required fields are present in the request body
  const { title, description } = req.body;
  if (!title || !description) {
    return res.status(400).send('Title and description are required');
  }

  // Logic to handle adding a new problem
  // For simplicity, let's assume we just push the new problem to the QUESTIONS array
  const newProblem = {
    title,
    description
  };
  QUESTIONS.push(newProblem);

  res.send('Problem added successfully');
});
  

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})