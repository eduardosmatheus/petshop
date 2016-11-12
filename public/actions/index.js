import axios from 'axios'

export const FETCH_BREEDS = 'FETCH_BREEDS'

const ROOT_URL = 'http://192.168.0.95/PetshopWebApi'

export function fetchBreeds() {
  const request = axios.get(`${ROOT_URL}/breeds`)
  return {
    type : FETCH_BREEDS,
    payload : request 
  }
}
