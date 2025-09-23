type Classmates = {
  section: string
}

type Students = {
  name: string
}

type ClassmatesInStudents = Classmates & Students;

let a: ClassmatesInStudents = {
  name: "harsh",
  section: 'a'
}

/*
type City = {
  name: string,
  population: number
}

type Planet = {
  name: string,
  cities: number
}

type CitiesInPlanet = City & Planet;

let value: CitiesInPlanet = {
  name: "Bhopal",
  population: 12000000,
  cities: 12
}
 */