package net.astrovel.traineechallenge

import net.astrovel.traineechallenge.account.core.AccountService
import net.astrovel.traineechallenge.account.core.InterfaceAccountService
import net.astrovel.traineechallenge.account.domain.Account
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TraineeChallengeApplicationTests() {

//    @Before
//    fun init() {
//        MockitoAnnotations.initMocks(this)
//    }

//    @Test
//    fun getAll() {
//        val postService = mock(InterfaceAccountService::class.java)
//        val postsRemoteDataSource = TraineeChallengeApplicationTests(postService)
//        var mList = listOf<Account>()
//
//        Mockito.`when`(postService.all()).blockingFirst()
//
//        val subscriber = postsRemoteDataSource.getAll().test()
//        subscriber.assertValueCount(10)
//        assertEquals(allPosts , CoreMatchers.`is`(10))
//
//    }

}
