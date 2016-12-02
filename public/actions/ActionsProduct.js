import axios from 'axios'

import {CLEAR_ACTUAL_PRODUCT, FETCH_PRODUCTS, CREATE_PRODUCT,
  GET_PRODUCT, UPDATE_PRODUCT, DELETE_PRODUCT,
  ERROR, ROOT_URL, errorDispatch} from './'

export const PRODUCTS_URL = 'products'

export function fetchProducts() {
  return dispatch => {
    axios.get(`${ROOT_URL}/${PRODUCTS_URL}`).then(response => {
      dispatch({
        type : FETCH_PRODUCTS,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function createProduct(product) {
  return dispatch => {
    axios.post(`${ROOT_URL}/${PRODUCTS_URL}`, product).then( response => {
      dispatch({
        type : CREATE_PRODUCT,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function getProduct(id) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${PRODUCTS_URL}/${id}`).then( response => {
      dispatch({
        type :  GET_PRODUCT,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}

export function updateProduct(product) {
  console.log(product);
  return dispatch => {
    axios.put(`${ROOT_URL}/${PRODUCTS_URL}`, product)
    .then( response => {
      dispatch({
        type :  UPDATE_PRODUCT,
        payload : response.data
      })
    }).catch(errorDispatch)
  }
}


export function deleteProduct(product) {
  return dispatch => {
    axios.delete(`${ROOT_URL}/${PRODUCTS_URL}/${product.id}`)
    .then( response => {
      dispatch({
        type :  DELETE_PRODUCT,
        payload : product
      })
    }).catch(errorDispatch)
  }
}

export function clearActualProduct() {
  return dispatch => {
    return dispatch({
      type : CLEAR_ACTUAL_PRODUCT
    })
  }
}

export function filterProduct(searchString) {
  return dispatch => {
    axios.get(`${ROOT_URL}/${PRODUCTS_URL}`).then(response => {
      dispatch({
        type : FETCH_PRODUCTS,
        payload : response.data.filter((product) => {
          return product.id == searchString || product.description.indexOf(searchString) != -1 //TODO: mover filtro para consulta no servidor 'FindLike'.
        })
      })
    }).catch(errorDispatch)
  }
}
