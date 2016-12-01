import { CLEAR_ACTUAL_ORDER, FETCH_ORDERS, CREATE_ORDER,
  GET_ORDER, UPDATE_ORDER, DELETE_ORDER,
  ERROR } from '../actions'

const INITIAL_STATE = {
  all: [],
  actual: {
    id: '',
    accessKey: '',
    price: 0,
    appointment: {
      id: '',
      appointmentConfig: {
        id: '',
        employeer: {
          id : '',
          name : '',
          cpf : '',
          phone : '',
          email : ''
        },
        entryTime: 0,
        lunchTime: 0,
        entryTimeAfterLunch: 0,
        homeTime: 0,
      },
      pet: {
        id: '',
        name: '',
        obs: '',
        especie: {
          id: '',
          name: ''
        },
        breed: {
          id: '',
          name:  ''
        },
        customer : {
          id : '',
          name : '',
          cpf : '',
          phone : '',
          email : ''
        }
      },
      date: '',
      entryTime: 0,
      outTime: 0,
      done: 0,
      obs: ''
    },
    itens: [
      {
        id: '',
        item: {
          id: '',
          description: '',
          price: 0,
          stockAmount: 0
        },
        amount: 0,
        unitPrice: 0
      }
    ]
  },
  error : null
}

export default function(state = INITIAL_STATE, action) {
  let {all, actual} = state
  switch (action.type) {
    case FETCH_ORDERS:
      return {...state, all : action.payload }
      break
    case CREATE_ORDER:
      all.push(action.payload)
      return {...state, all : state.all}
      break
    case UPDATE_ORDER:
      all = all.map((ob) => {
        if(ob.id === actual.id) {
          return action.payload
        }
        return ob
      })
      return {...state, all : all, actual : INITIAL_STATE.actual}
      break
    case DELETE_ORDER:
      let x = all.indexOf(action.payload)
      all.splice(x, 1)
      return {...state, all : state.all, actual : INITIAL_STATE.actual}
      break
    case GET_ORDER:
      return {...state, actual : action.payload }
      break
    case CLEAR_ACTUAL_ORDER:
      return {...state, actual : INITIAL_STATE.actual}
      break
    case ERROR :
      return {...state, error : action.error}
      break
  }

  return state;
}
