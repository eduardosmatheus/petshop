import axios from 'axios'

export const FETCH_BREEDS = 'FETCH_BREEDS'
export const ERROR = 'ERROR'

const ROOT_URL = 'http://192.168.0.95/PetshopWebApi'

export function fetchBreeds() {
  return dispatch => {
    axios.get(`${ROOT_URL}/breeds`).then(data => {
      dispatch({
        type : FETCH_BREEDS,
        payload : data
      })
    }).catch(err => {
      dispatch({
        type : ERROR,
        error : err
      })
    })
  } 
}
