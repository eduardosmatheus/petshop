import axios from 'axios'

import {FETCH_BREEDS, CREATE_BREED, ERROR, ROOT_URL, errorDispatch} from './'
export const BREEDS_URL = 'breeds'

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

export function createBreed(props) {
  return dispatch => {
    axios.post(`${ROOT_URL}/${BREEDS_URL}`, props.name, { headers : {'Content-Type' : 'text/plain'} }).then( response => {
      dispatch({
        type : CREATE_BREED,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}
