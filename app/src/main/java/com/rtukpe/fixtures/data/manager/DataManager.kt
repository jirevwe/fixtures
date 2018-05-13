package com.rtukpe.fixtures.data.manager


import com.rtukpe.fixtures.data.repository.local.interfaces.LocalDataInterface
import com.rtukpe.fixtures.data.repository.mock.MockerInterface
import com.rtukpe.fixtures.data.repository.remote.api.RemoteServiceApi

/**
 * Created by rtukpe on 14/03/2018.
 */

interface DataManager : RemoteServiceApi, LocalDataInterface, MockerInterface
