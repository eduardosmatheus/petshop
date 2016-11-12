import axios from 'axios'

export const FETCH_BREEDS = 'FETCH_BREEDS'
export const ERROR = 'ERROR'

const ROOT_URL = 'http://localhost:8080/PetshopWebApi'

export function fetchBreeds() {
  return dispatch => {
    axios.get(`${ROOT_URL}/breeds`).then(response => {
      dispatch({
        type : FETCH_BREEDS,
        payload : response.data
      })
    }).catch(err => {
      dispatch({
        type : ERROR,
        error : err
      })
    })
  }
}
