import axios from 'axios'

export const FETCH_BREEDS = 'FETCH_BREEDS'
export const ERROR = 'ERROR'
export const POST_USER = 'POST_USER'

const ROOT_URL = 'http://localhost:8080/PetshopWebApi'
const BREEDS_URL = 'breeds'

const errorDispatch = ((err) => ({ type : ERROR, error : err })  )

export function fetchBreeds() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${BREEDS_URL}`).then(response => {
      dispatch({
        type : FETCH_BREEDS,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function postBreed(breedName) {
  return dispatch => {
    axios.post(`${ROOT_URL}/${BREEDS_URL}`, breedName, { headers : {'Content-Type' : 'text/plain'} }).then( response => {
      dispatch({
        type : POST_USER,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}
