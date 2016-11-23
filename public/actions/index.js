export const FETCH_BREEDS = 'FETCH_BREEDS'
export const CREATE_BREED = 'CREATE_BREED'
export const GET_BRRED = 'GET_BRRED'
export const UPDATE_BREED = 'UPDATE_BREED'
export const DELETE_BREED = 'DELETE_BREED'
export const CLEAR_ACTUAL_BREED = 'CLEAR_ACTUAL_BREED'
export const ERROR = 'ERROR'
export const ROOT_URL = 'http://localhost:8080/PetshopWebApi'
export const errorDispatch = ((err) => ({ type : ERROR, error : err })  )
