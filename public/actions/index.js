export const FETCH_BREEDS = 'FETCH_BREEDS'
export const CREATE_BREED = 'CREATE_BREED'
export const GET_BREED = 'GET_BREED'
export const UPDATE_BREED = 'UPDATE_BREED'
export const DELETE_BREED = 'DELETE_BREED'
export const CLEAR_ACTUAL_BREED = 'CLEAR_ACTUAL_BREED'

export const FETCH_ESPECIES = 'FETCH_ESPECIES'
export const CREATE_ESPECIE = 'CREATE_ESPECIE'
export const GET_ESPECIE = 'GET_ESPECIE'
export const UPDATE_ESPECIE = 'UPDATE_ESPECIE'
export const DELETE_ESPECIE = 'DELETE_ESPECIE'
export const CLEAR_ACTUAL_ESPECIE = 'CLEAR_ACTUAL_ESPECIE'

export const ERROR = 'ERROR'
export const ROOT_URL = 'http://localhost:8080/PetshopWebApi'
export const errorDispatch = ((err) => ({ type : ERROR, error : err })  )
