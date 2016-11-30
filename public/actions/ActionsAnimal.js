import axios from 'axios'

import {CLEAR_ACTUAL_ANIMAL, FETCH_ANIMALS, CREATE_ANIMAL,
  GET_ANIMAL, UPDATE_ANIMAL, DELETE_ANIMAL,
  ERROR, ROOT_URL, errorDispatch} from './'

export const ANIMALS_URL = 'animals'

export function fetchAnimals() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${ANIMALS_URL}`).then(response => {
      dispatch({
        type : FETCH_ANIMALS,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function createAnimal(animal) {
  return dispatch => {
    axios.post(`${ROOT_URL}/${ANIMALS_URL}`, animal).then( response => {
      dispatch({
        type : CREATE_ANIMAL,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function getAnimal(id) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${ANIMALS_URL}/${id}`).then( response => {
      dispatch({
        type :  GET_ANIMAL,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function updateAnimal(animal) {
  return dispatch => {
    axios.put(`${ROOT_URL}/${ANIMALS_URL}`, animal)
    .then( response => {
      dispatch({
        type :  UPDATE_ANIMAL,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}


export function deleteAnimal(animal) {
  return dispatch => {
    axios.delete(`${ROOT_URL}/${ANIMALS_URL}/${animal.id}`)
    .then( response => {
      dispatch({
        type :  DELETE_ANIMAL,
        payload : animal
      })
    }).catch(errorDispatch)
  }
}

export function clearActualAnimal() {
  return dispatch => {
    return dispatch({
      type : CLEAR_ACTUAL_ANIMAL
    })
  }
}

export function filterAnimal(searchString) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${ANIMALS_URL}`).then(response => {
      console.log(response.data);
      dispatch({
        type : FETCH_ANIMALS,
        payload : response.data.filter((animal) => {
          console.log('esse: ', animal);
          return animal.id == searchString
            || animal.name.indexOf(searchString) != -1
            || animal.customer.name.indexOf(searchString) != -1 || animal.customer.cpf.indexOf(searchString) != -1
            || animal.breed.name.indexOf(searchString) != -1
            || animal.especie.description.indexOf(searchString) != -1
            || animal.obs.indexOf(searchString) != -1
        })
      })
    }).catch(errorDispatch)
  }
}
